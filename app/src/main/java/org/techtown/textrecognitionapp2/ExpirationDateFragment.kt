package org.techtown.textrecognitionapp2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.techtown.textrecognitionapp2.databinding.FragmentExpirationDateBinding
import org.techtown.textrecognitionapp2.MainActivity

class ExpirationDateFragment : Fragment() {
    var mainActivity: MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is MainActivity) mainActivity = context
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentExpirationDateBinding.inflate(inflater, container, false)
        binding.btnBack.setOnClickListener { mainActivity?.goBarcode() }
        binding.btnBackMain.setOnClickListener { mainActivity?.goMain() }
        binding.btnExpirationDate.setOnClickListener { mainActivity?.dispatchTakePictureIntent() }
        return binding.root
    }

}