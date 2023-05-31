package com.example.api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api.databinding.ItemList3Binding

class ListAdapter3: RecyclerView.Adapter<ListAdapter3.MyView>() {
    private var parkingList = listOf<Row3>()

    inner class MyView(private val binding: ItemList3Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            val response = parkingList[pos]
            binding.textView5.text = "행사 이름 : ${response.tITLE}"
            binding.textView6.text = "장소 : ${response.pLACE}"
            binding.textView7.text = "날짜/시간 : ${response.dATE}"
            binding.textView8.text = "프로그램 소개 : ${response.pROGRAM}"
            binding.textView9.text = "출연자 : ${response.pLAYER}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = ItemList3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return parkingList.size
    }
    fun setList(list: List<Row3>) {
        parkingList = list
    }
}