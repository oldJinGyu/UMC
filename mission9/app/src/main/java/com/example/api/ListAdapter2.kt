package com.example.api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api.databinding.ItemList2Binding

class ListAdapter2: RecyclerView.Adapter<ListAdapter2.MyView>() {
    private var parkingList = listOf<Row2>()

    inner class MyView(private val binding: ItemList2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            val response = parkingList[pos]
            binding.textView.text = "주차장 이름 : ${response.pARKINGNAME}"
            binding.textView2.text = "주차장 주소 : ${response.aDDR}"
            binding.textView3.text = "주차장 전화번호 : ${response.tEL}"
            binding.textView4.text = "주차장 유무료 여부 : ${response.pAYNM}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = ItemList2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return parkingList.size
    }
    fun setList(list: List<Row2>) {
        parkingList = list
    }
}