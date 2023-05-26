package com.example.mission8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mission8.databinding.StarBinding

class StarAdapter(private val memoList: List<Memo>): RecyclerView.Adapter<StarAdapter.viewHolder>()  {
    inner class viewHolder(val binding: StarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(memo: Memo, position: Int) {
            binding.textNum.text = memo.no.toString()
            binding.textTitle.text = memo.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarAdapter.viewHolder {
        val binding = StarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun getItemCount() = memoList.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val memo = memoList[position]
        holder.bind(memo, position)
    }
}