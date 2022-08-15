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

class MainActivity : AppCompatActivity(),OnInitListener {
    var barcode: String? = null//바코드
    var tts: TextToSpeech? = null//음성 안내
    var expirationDate: String? = null//유통기한
    var imageBitmap: Bitmap? = null//유통기한 이미지 받을 변수
    var barList:List<BarDBActivity>?=null//공공DB 정보 담을 리스트(데이터 타입:BarDBActivity 식품 객체, 객체 멤버 변수: 바코드, 식품명)
    var informationList: ArrayList<InformationData>? = null//사용자DB 정보 담을 리스트(데이터 타입:InformationData 식품 객체, 객체 멤버 변수: 순번, 식품명, 유통기한)
    var cnt:Int=0//식품 순번
    var mDbHelper2:UserAdapter?=null//UserAdapter:사용자DB 관련 클래스

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.setupForAccessibility()
        setContentView(binding.root)
        tts = TextToSpeech(this, this)

        //공공데이터 DB 불러오기
        var mDbHelper = BarAdapter(applicationContext)//BarAdapter:공공DB 관련 클래스
        mDbHelper.createDatabase()
        mDbHelper.open()
        barList = mDbHelper.tableData as List<BarDBActivity>//공공DB 정보 리스트로 받아오기

        //사용자 DB 불러오기
        mDbHelper2=UserAdapter(applicationContext)//UserAdapter:사용자DB 관련 클래스
        mDbHelper2?.createDatabase()
        mDbHelper2?.open()
        informationList = mDbHelper2?.tableData as ArrayList<InformationData>//사용자DB 정보 리스트로 받아오기

        setMainFragment()
    }

    //메인 프래그먼트 설정
    fun setMainFragment() {
        val mainFragment: MainFragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, mainFragment)
        transaction.commit()
    }
    //바코드 프래그먼트로 이동
    fun goBarcode() {
        val barcodeFragment = BarcodeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, barcodeFragment)
        transaction.addToBackStack("barcode")
        transaction.commit()
    }
    //유통기한 프래그먼트로 이동
    fun goExpirationDate() {
        val expirationDateFragment = ExpirationDateFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, expirationDateFragment)
        transaction.addToBackStack("expirationDate")
        transaction.commit()
    }
    //메인 프래그먼트로 이동
    fun goMain() {
        val mainFragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, mainFragment)
        transaction.addToBackStack("main")
        transaction.commit()
    }
    //식품 정보 확인 프래그먼트로 이동
    fun goInformation() {
        val informationFragment = InformationFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, informationFragment)
        transaction.addToBackStack("Information")
        intent.putExtra("informationData", informationList)
        transaction.commit()
    }

    //바코드 촬영 후 onActivityResult 함수로 전달
    fun startBarcodeReader() {
        IntentIntegrator(this).initiateScan()
    }
    //유통기한 촬영 후 onActivityResult 함수로 전달
    fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }
    //바코드, 유통기한 처리 코드(if문:유통기한 사진인 경우, else문:바코드인 경우)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){//requestCode 이용해 전달된 값이 바코드 스캔값인지 유통기한 사진인지 구분
            val extras = data!!.extras
            imageBitmap = extras!!["data"] as Bitmap?//imageBitmap 변수에 유통기한 이미지 대입
            detectTextFromImage()//이미지로부터 글자 인식하는 함수로 이동
        }
        else{
            val result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
            if(result!=null){
                barcode=result.contents+".0"//DB에 바코드.0 형태로 저장되어 있어 이와 형태를 맞춰줌
                //공공DB 정보 담은 리스트(데이터 타입:BarDBActivity 식품 객체, 멤버 변수: 바코드, 식품명)에 바코드 값 있는지 검색
                for (i in barList?.indices!!) {
                    if (barcode == barList!!.get(i).COL_BARCODE) {//찍은 바코드값과 일치하는 바코드값 가진 식품 객체 존재 시
                        barcode=barList!!.get(i).COL_BARNAME//바코드 변수에 해당 식품 객체의 식품명 대입
                    }
                }
                Toast.makeText(this,barcode,Toast.LENGTH_LONG).show()//식품명 토스트 메시지로 띄우기
                speakBarcode()//식품명 음성 안내 함수로 이동
            } else{
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
    //유통기한 사진으로부터 글자 인식
    fun detectTextFromImage() {
        val inputImage = InputImage.fromBitmap(imageBitmap!!, 0)
        val textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)//ML KIT 이용한 text recognition
        textRecognizer.process(inputImage)//이미지로부터 글자 인식
            .addOnSuccessListener { text -> displayTextFromImage(text) }//유통기한 띄워주는 함수로 이동
            .addOnFailureListener { e ->
                Toast.makeText(this@MainActivity, "Error" + e.message, Toast.LENGTH_SHORT).show()
                Log.d("Error: ", e.message!!)
            }
    }
    //글자수, 유통기한 형식 확인 후 유통기한 띄우기
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
                if(dateIndex=="2"){//인식한 글자가 유통기한 형식에 맞는 경우(유통기한 맨 앞글자가 2인지 검사)
                    cnt= informationList!!.size+1//식품 목록 순번
                    val info=InformationData(cnt,barcode,expirationDate)//순번, 식품명, 유통기한 지정해 InformationData 식품 객체 생성
                    informationList!!.add(info)//식품 목록 리스트에 식품 객체 추가
                    mDbHelper2?.insert(cnt,barcode,expirationDate)//insert DB
                    Toast.makeText(this,expirationDate,Toast.LENGTH_SHORT).show();//유통기한 토스트 메시지로 띄우기
                    speakExpirationDate()//유통기한 음성 안내 함수로 이동
                }
                else{//인식한 글자가 유통기한 형식에 맞지 않는 경우
                    expirationDate = null
                    Toast.makeText(this,"유통기한을 인식하지 못했습니다. 다시 찍어주세요.",Toast.LENGTH_SHORT).show();
                    speakExpirationDate()//유통기한 음성 안내 함수로 이동(이 경우 인식하지 못했다고 안내)
                }
            }
        }
    }
    //바코드 음성 안내 코드
    fun speakBarcode(){
        val text: String? = barcode
        tts!!.setPitch(0.6.toFloat())
        tts!!.setSpeechRate(1.2.toFloat())
        if(text==null){
            tts!!.speak("바코드를 인식해 식품명을 음성 안내 받으시거나 식품 사진을 촬영하신 후 유통기한을 음성 안내 받으시려면 화면 위에 있는 식품 유통기한 확인 버튼을, 저장된 식품을 보시려면 화면 아래에 있는 식품 정보 확인 버튼을 눌러주세요.", TextToSpeech.QUEUE_FLUSH,null,"id2")
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
    //음성 소멸 코드
    override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
    //음성 초기화 코드
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.KOREA)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported")
            } else {
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