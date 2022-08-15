package org.techtown.textrecognitionapp2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.techtown.textrecognitionapp2.databinding.FragmentInformationBinding

class InformationFragment : Fragment() {
    var mainActivity: MainActivity? = null
    var list:ArrayList<InformationData>?=null
    lateinit var customAdapter: CustomAdapter
    lateinit var binding: FragmentInformationBinding
    var mDbHelper:UserAdapter?=null

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
        binding = FragmentInformationBinding.inflate(inflater, container, false)
        binding.btnInfoToMain.setOnClickListener { mainActivity?.goMain() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDbHelper=UserAdapter(mainActivity)
        //mDbHelper?.createDatabase()
        mDbHelper?.open()

        list= requireActivity().intent!!.extras!!.get("informationData") as ArrayList<InformationData>

        // Fragment에서 전달받은 list를 넘기면서 ListAdapter 생성
        customAdapter = CustomAdapter(list!!, onClickDeleteIcon = {deleteTask(it)})

        // RecyclerView.adapter에 지정
        binding.recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = customAdapter
    }

    fun deleteTask(info:InformationData){
        list?.remove(info)
        info.getNo()?.let { mDbHelper?.delete(it) } //
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}