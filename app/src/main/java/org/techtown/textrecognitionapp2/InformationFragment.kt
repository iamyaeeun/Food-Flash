package org.techtown.textrecognitionapp2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.techtown.textrecognitionapp2.databinding.FragmentInformationBinding

class InformationFragment : Fragment() {
    var mainActivity: MainActivity? = null
    lateinit var customAdapter: CustomAdapter

    lateinit var binding: FragmentInformationBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformationBinding.inflate(inflater, container, false)
        binding.btnInfoToMain.setOnClickListener { mainActivity?.goMain() }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var list: ArrayList<InformationData> = requireActivity().intent!!.extras!!.get("informationData") as ArrayList<InformationData>

        // Fragment에서 전달받은 list를 넘기면서 ListAdapter 생성
        customAdapter = CustomAdapter(list)

        // RecyclerView.adapter에 지정
        binding.recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = customAdapter

    }

}