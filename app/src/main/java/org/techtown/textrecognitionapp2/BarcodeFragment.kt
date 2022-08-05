package kr.co.sungshin.foodflash

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.sungshin.foodflash.databinding.FragmentBarcodeBinding

/*
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BarcodeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
 */
class BarcodeFragment : Fragment() {

    var mainActivity: MainActivity? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is MainActivity) mainActivity = context
    }

    /*
        // TODO: Rename and change types of parameters
        private var param1: String? = null
        private var param2: String? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            arguments?.let {
                param1 = it.getString(ARG_PARAM1)
                param2 = it.getString(ARG_PARAM2)
            }
        }
        */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_barcode, container, false)
        val binding = FragmentBarcodeBinding.inflate(inflater, container, false)
        binding.btnNext.setOnClickListener { mainActivity?.goExpirationDate() }
        binding.btnBackToMain.setOnClickListener { mainActivity?.goMain() }
        return binding.root
    }
    /*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BarcodeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BarcodeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    */
}