package org.techtown.textrecognitionapp2

import android.graphics.drawable.Icon
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.textrecognitionapp2.databinding.ItemRecyclerBinding

class CustomAdapter(private var list: ArrayList<InformationData>,val onClickDeleteIcon: (info:InformationData)->Unit): RecyclerView.Adapter<CustomAdapter.ListItemViewHolder>() {

    inner class ListItemViewHolder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root){
        //var dataNo: TextView = itemView!!.findViewById(R.id.textNo)
        //var dataTitle: TextView = itemView!!.findViewById(R.id.textTitle)
        //var dataDate: TextView = itemView!!.findViewById(R.id.textDate)

        fun bind(data: InformationData, position: Int) {
            binding.textNo.text = "${data.getNo()}"
            binding.textTitle.text = data.getTitle()
            binding.textDate.text = data.getDate()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder  {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position], position)
        holder.binding.btnDelete.setOnClickListener{
            onClickDeleteIcon.invoke(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.count()
    }
}
