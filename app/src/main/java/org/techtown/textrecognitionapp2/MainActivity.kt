package org.techtown.textrecognitionapp2

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.google.zxing.integration.android.IntentIntegrator
import org.techtown.textrecognitionapp2.databinding.ActivityMainBinding
import java.util.*

fun FragmentManager.setupForAccessibility() {
    addOnBackStackChangedListener {
        val lastFragmentWithView = fragments.last { it.view != null }
        for (fragment in fragments) {
            if (fragment == lastFragmentWithView) {
                fragment.view?.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
            } else {
                fragment.view?.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS
            }
        }
    }
}

class MainActivity : AppCompatActivity(),OnInitListener {
    var barcode: String? = null
    var tts: TextToSpeech? = null
    var expirationDate: String? = null
    var imageBitmap: Bitmap? = null
    //var msg: String? = null
    var barList:List<BarDBActivity>?=null
    var informationList: ArrayList<InformationData> = loadData(barcode,expirationDate)
    var cnt:Int=0
    var mDbHelper2:UserAdapter?=null

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    fun loadData(barcode:String? , expirationDate:String?): ArrayList<InformationData> {
        val data: ArrayList<InformationData> = arrayListOf()
        val title = barcode
        val date = expirationDate
        var allInfo = InformationData(cnt,title,date)
        data.add(allInfo)//if(title!=null&&date!=null) 추가하기
        return data
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.setupForAccessibility() //추가코드

        setContentView(binding.root)
        tts = TextToSpeech(this, this)

        //공공데이터 DB 불러오기
        var mDbHelper = BarAdapter(applicationContext)
        mDbHelper.createDatabase()
        mDbHelper.open()
        barList = mDbHelper.tableData as List<BarDBActivity>

        //사용자 DB 불러오기
        mDbHelper2=UserAdapter(applicationContext)
        mDbHelper2?.createDatabase()
        mDbHelper2?.open()
        informationList = mDbHelper2?.tableData as ArrayList<InformationData>

        /*
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, InformationFragment())
        transaction.commit()
        intent.putExtra("informationData", informationList)

         */

        setMainFragment()
    }

    fun setMainFragment() {
        val mainFragment: MainFragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, mainFragment)
        transaction.commit()
    }
    fun goBarcode() {
        val barcodeFragment = BarcodeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, barcodeFragment)
        transaction.addToBackStack("barcode")
        transaction.commit()
    }
    fun goExpirationDate() {
        val expirationDateFragment = ExpirationDateFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, expirationDateFragment)
        transaction.addToBackStack("expirationDate")
        transaction.commit()
    }
    fun goMain() {
        val mainFragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, mainFragment)
        transaction.addToBackStack("main")
        transaction.commit()
    }

    fun goInformation() {
        val informationFragment = InformationFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, informationFragment)
        transaction.addToBackStack("Information")
        intent.putExtra("informationData", informationList)
        transaction.commit()
    }

    //바코드 촬영 코드 (여기부터 예은 추가)
    fun startBarcodeReader() {
        IntentIntegrator(this).initiateScan()
    }
    //유통기한 촬영 코드
    fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }
    //유통기한 사진으로부터 글자 인식
    fun detectTextFromImage() {
        val inputImage = InputImage.fromBitmap(imageBitmap!!, 0)
        val textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
        textRecognizer.process(inputImage)
            .addOnSuccessListener { text -> displayTextFromImage(text) }
            .addOnFailureListener { e ->
                Toast.makeText(this@MainActivity, "Error" + e.message, Toast.LENGTH_SHORT).show()
                Log.d("Error: ", e.message!!)
            }
    }
    //인식한 유통기한 띄우기
    fun displayTextFromImage(text: Text) {
        val blockList = text.textBlocks
        if (blockList.size == 0) {//글자를 인식하지 못한 경우
            expirationDate = null
            Toast.makeText(this,"유통기한을 인식하지 못했습니다. 다시 찍어주세요.",Toast.LENGTH_SHORT).show();
            speakExpirationDate()
        } else {//글자를 인식한 경우
            for (block in text.textBlocks) {
                expirationDate=block.text
                val dateIndex:String=expirationDate!!.substring(0 until 1)

                if(dateIndex=="2"){//인식한 글자가 유통기한 형식에 맞는 경우
                    cnt=informationList.size
                    val info=InformationData(cnt,barcode,expirationDate)
                    informationList.add(info)
                    //insert DB
                    mDbHelper2?.insert(cnt,barcode,expirationDate)
                    Toast.makeText(this,expirationDate,Toast.LENGTH_SHORT).show();
                    speakExpirationDate()
                }
                else{//인식한 글자가 유통기한 형식에 맞지 않는 경우
                    expirationDate = null
                    Toast.makeText(this,"유통기한을 인식하지 못했습니다. 다시 찍어주세요.",Toast.LENGTH_SHORT).show();
                    speakExpirationDate()
                }
            }
        }
    }

    //바코드, 유통기한 처리 코드(if문:유통기한 사진인 경우, else문:바코드인 경우)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            val extras = data!!.extras
            imageBitmap = extras!!["data"] as Bitmap?
            detectTextFromImage()
        }
        else{
            val result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
            if(result!=null){
                barcode=result.contents+".0"
                //DB에 바코드 값 있는지 검색
                for (i in barList?.indices!!) {
                    if (barcode == barList!!.get(i).COL_BARCODE) {
                        barcode=barList!!.get(i).COL_BARNAME
                    }
                }
                Toast.makeText(this,barcode,Toast.LENGTH_LONG).show()
                speakBarcode()
            } else{
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
    //바코드 음성 안내 코드
    fun speakBarcode(){
        val text: String? = barcode
        tts!!.setPitch(0.6.toFloat())
        tts!!.setSpeechRate(1.2.toFloat())
        if(text==null){
            tts!!.speak("바코드를 인식하여 식품명을 음성 안내 받으시거나 식품 사진을 촬영하신 후 유통기한을 음성 안내 받으시려면 화면 위에 있는 식품 유통기한 확인 버튼을, 저장된 식품을 보시려면 화면 아래에 있는 식품 정보 확인 버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH,null,"id2")
        }
        else{
            tts!!.speak("이 식품은 "+text+"입니다. 유통기한을 촬영하시려면 오른쪽 하단에 있는 next 버튼을 누른뒤 화면 상단에 있는 유통기한 촬영 버튼을, 메인 화면으로 돌아가시려면 왼쪽 하단에 있는 처음으로 버튼을 눌러주세요", TextToSpeech.QUEUE_FLUSH, null, "id1")
        }
    }
    //유통기한 음성 안내 코드
    fun speakExpirationDate(){
        val text: String? = expirationDate
        tts!!.setPitch(0.6.toFloat())
        tts!!.setSpeechRate(1.2.toFloat())
        if(text==null) tts!!.speak("유통기한을 인식하지 못했습니다. 다시 찍어주세요.", TextToSpeech.QUEUE_FLUSH, null, "id4")
        else tts!!.speak("이 식품의 유통기한은"+expirationDate+"입니다. 메인으로 돌아가시려면 오른쪽 하단에 있는 버튼을, 바코드를 인식하여 상품명을 다시 안내받으시려면 왼쪽 하단에 있는 뒤로가기 버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH, null, "id3")
    }
    //음성 초기화, 소멸 코드
    override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.KOREA)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported")
            } else {
                //btn_speak.setEnabled(true);
                speakBarcode()
            }
        } else {
            Log.e("TTS", "Initilization Failed!")
        }
    }
    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
    }

}