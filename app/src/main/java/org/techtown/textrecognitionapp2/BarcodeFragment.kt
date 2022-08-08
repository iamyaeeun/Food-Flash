package org.techtown.textrecognitionapp2

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import org.techtown.textrecognitionapp2.databinding.FragmentBarcodeBinding
import org.techtown.textrecognitionapp2.MainActivity
import java.util.*

class BarcodeFragment : Fragment(){
    var mainActivity: MainActivity? = null
    var text:TextView?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_barcode, container, false)

        val binding = FragmentBarcodeBinding.inflate(inflater, container, false)
        binding.btnNext.setOnClickListener { mainActivity?.goExpirationDate() }
        binding.btnBackToMain.setOnClickListener { mainActivity?.goMain() }
        //추가
        binding.btnBarcode.setOnClickListener {mainActivity?.startBarcodeReader()}
        return binding.root
    }

}