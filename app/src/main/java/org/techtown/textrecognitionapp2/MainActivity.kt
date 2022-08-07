package org.techtown.textrecognitionapp2

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.google.zxing.integration.android.IntentIntegrator
import org.techtown.textrecognitionapp2.databinding.ActivityMainBinding
import org.techtown.textrecognitionapp2.databinding.FragmentInformationBinding
import java.util.*

class MainActivity : AppCompatActivity(),OnInitListener {
    var barcode: String? = null
    var tts: TextToSpeech? = null
    var expirationDate: String? = null
    //var imageView: ImageView? = null
    var textView: TextView? = null
    var textView2: TextView? = null
    var imageBitmap: Bitmap? = null
    var msg: String? = null

    val binding_main by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val binding by lazy { FragmentInformationBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding_main.root)
        //imageView = findViewById<ImageView>(R.id.image_view)
        textView= findViewById<TextView>(R.id.textView)
        textView2=findViewById<TextView>(R.id.textView2)
        tts = TextToSpeech(this, this)

        val data:MutableList<Memo> = loadData()
        var adapter = CustomAdapter()
        adapter.listData = data
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

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
        //onBackPressed()
        val mainFragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, mainFragment)
        transaction.addToBackStack("main")
        transaction.commit()
    }

    fun goInformation() {
        //onBackPressed()
        val informationFragment = InformationFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, informationFragment)
        transaction.addToBackStack("Information")
        transaction.commit()
    }

    fun loadData(): MutableList<Memo> {
        val data: MutableList<Memo> = mutableListOf()
        for (no in 1..100) {
            val title = "비요뜨 ${no}"
            val date = System.currentTimeMillis()
            var memo = Memo(no,title, date)
            data.add(memo)
        }
        return data
    }

    //바코드 촬영 코드
    fun startBarcodeReader() {
        IntentIntegrator(this).initiateScan()
    }

    //바코드 음성 안내 코드
    fun speakBarcode(){
        val text: String? = barcode
        tts!!.setPitch(0.6.toFloat())
        tts!!.setSpeechRate(0.1.toFloat())
        if(text==null){
            tts!!.speak("식품을 찍어주시면 유통기한을 음성 안내 해드립니다.", TextToSpeech.QUEUE_FLUSH,null,"id2")
        }
        else{
            tts!!.speak("이 식품은 "+text+"입니다. 유통기한을 촬영하려면 오른쪽 하단에 있는 버튼을, 메인 화면으로 돌아가려면 왼쪽 하단에 있는 버튼을 눌러주세요", TextToSpeech.QUEUE_FLUSH, null, "id1")
        }
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
        if (blockList.size == 0) {
            msg = "글자를 인식하지 못했습니다. 다시 찍어주세요."
            //textView2!!.text = msg
            Toast.makeText(this,"No Text Found in image.",Toast.LENGTH_SHORT).show();
            speakExpirationDate()
        } else {
            for (block in text.textBlocks) {
                msg = block.text
                //textView2!!.text = msg
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                speakExpirationDate()
            }
        }
    }
    //바코드, 유통기한 처리 코드(if문:유통기한 사진인 경우, else문:바코드인 경우)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            val extras = data!!.extras
            imageBitmap = extras!!["data"] as Bitmap?
            //imageView!!.setImageBitmap(imageBitmap)
        }
        else{
            val result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
            if(result!=null){
                barcode=result.contents
                Toast.makeText(this,barcode,Toast.LENGTH_LONG).show()
                //textView!!.text=barcode6
                speakBarcode()
            } else{
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    //유통기한 음성 안내 코드
    fun speakExpirationDate(){
        val text: String? = msg
        tts!!.setPitch(0.6.toFloat())
        tts!!.setSpeechRate(0.1.toFloat())
        tts!!.speak("이 식품의 유통기한은"+msg+"입니다.", TextToSpeech.QUEUE_FLUSH, null, "id3")
    }

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
                //speakBarcode() //speakOut();
            }
        } else {
            Log.e("TTS", "Initilization Failed!")
        }
    }
    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
    }
}