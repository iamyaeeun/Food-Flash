package org.techtown.textrecognitionapp2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.textrecognitionapp2.databinding.ItemRecyclerBinding

class CustomAdapter(private var list: ArrayList<InformationData>,val onClickDeleteIcon: (info:InformationData)->Unit): RecyclerView.Adapter<CustomAdapter.ListItemViewHolder>() {
                                // list를 넘겨받음

    // 내부 class로 ViewHolder를 정의
    inner class ListItemViewHolder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root){
        // onBindViewHolder 역할을 대신 함
        fun bind(data: InformationData, position: Int) {
            binding.textNo.text = "${data.getNo()}"
            binding.textTitle.text = data.getTitle()
            binding.textDate.text = data.getDate()
        }
    }

    // ViewHolder에게 item을 보여줄 View로 쓰이는 item_recycler.xml를 넘기면서 ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder  {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(binding)
    }

    // ViewHolder의 bind 메소드를 호출
    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position], position)
        holder.binding.btnDelete.setOnClickListener{ onClickDeleteIcon.invoke(list[position]) } // item을 삭제하는 함수 호출
    }

    override fun getItemCount(): Int {
        return list.count()
    }
}