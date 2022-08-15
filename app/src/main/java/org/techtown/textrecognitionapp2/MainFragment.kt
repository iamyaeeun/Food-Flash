package org.techtown.textrecognitionapp2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.techtown.textrecognitionapp2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    var mainActivity: MainActivity? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is MainActivity) mainActivity = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.setupForAccessibility()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false)

        /*
        var rootView = inflater.inflate(R.layout.activity_main, null, false);
        rootView.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS);

        if(rootView != null) {
            rootView.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
        }
         */

        val binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.btnStart.setOnClickListener { mainActivity?.goBarcode() }
        binding.btnStart2.setOnClickListener { mainActivity?.goInformation() }
        return binding.root
    }
}