package com.example.api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api.databinding.ItemListBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyView>() {
    private var cycleList = listOf<Row>()

    inner class MyView(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pos: Int) {
            val response = cycleList[pos]
            binding.text01.text = "대여소 이름 : ${response.stationName}"
            binding.text02.text = "자전거 주차 총 건수 : ${response.parkingBikeTotCnt}"
            binding.text03.text = "거치율 : ${response.shared}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return cycleList.size
    }

    fun setList(list: List<Row>) {
        cycleList = list
    }
}