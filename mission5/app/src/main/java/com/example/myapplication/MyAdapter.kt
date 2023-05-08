package com.example.myapplication

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemBinding

class MyAdapter(private val dataList: MutableList<UserSwitch>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val userCheckSwitchStatus = SparseBooleanArray()

    inner class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val switch = binding.sw

        fun bind(userSwitch: UserSwitch, position: Int) {
            binding.swName.text = userSwitch.title
            switch.isChecked = userCheckSwitchStatus.get(position)
            switch.setOnCheckedChangeListener { _, isChecked ->
                userCheckSwitchStatus.put(position, isChecked)
                userSwitch.isChecked = isChecked
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position], position)
    }

    override fun getItemCount() = dataList.size

    override fun onViewRecycled(holder: MyViewHolder) {
        val position = holder.absoluteAdapterPosition
        userCheckSwitchStatus.put(position, holder.switch.isChecked)
        holder.switch.setOnCheckedChangeListener(null)
        super.onViewRecycled(holder)
    }
}