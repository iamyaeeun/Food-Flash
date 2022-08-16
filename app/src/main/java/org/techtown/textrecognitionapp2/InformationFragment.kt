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
    var list:ArrayList<InformationData>?=null // 사용자의 음식 정보가 담겨있는 list 생성

    lateinit var customAdapter: CustomAdapter // 어댑터 생성

    lateinit var binding: FragmentInformationBinding
    var mDbHelper:UserAdapter?=null

    override fun onAttach(context: Context) { // 넘어온 Context를 인자로 받음
        super.onAttach(context)

        if(context is MainActivity) mainActivity = context // Context 타입이 MainActivity인 것을 확인한 후 프로퍼티에 저장
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.setupForAccessibility() // 프래그먼트 접근성이 이전 프래그먼트 view에 유지되어 보이스 오버 사용에 문제가 생기는 현상을 해결하기 위해 코드 추가
        // 새로 정의한 FragmentManager의 setupForAccessibility() 호출
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 버튼 클릭 시 main에 있는 fragment 이동 함수가 실행되도록 함
        binding = FragmentInformationBinding.inflate(inflater, container, false)
        binding.btnInfomationToMain.setOnClickListener { mainActivity?.goMain() }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDbHelper=UserAdapter(mainActivity)
        mDbHelper?.open()

        // MainActivity에서 intent로 넘긴 데이터를 받아옴
        list = requireActivity().intent!!.extras!!.get("informationData") as ArrayList<InformationData>

        // Fragment에서 전달받은 list를 넘기면서 Adapter 생성
        customAdapter = CustomAdapter(list!!, onClickDeleteIcon = {deleteTask(it)})

        // recyclerView를 화면에 보여주는 형태를 결정하기 위해 레이아웃 매니저를 연결
        binding.recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        // RecyclerView.adapter에 지정
        binding.recyclerView.adapter = customAdapter
    }

    fun deleteTask(info:InformationData){ //item을 삭제하는 함수
        list?.remove(info)
        info.getNo()?.let { mDbHelper?.delete(it) } //No 변수값을 받아 item을 삭제
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}