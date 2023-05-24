package com.example.mission8

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mission8.databinding.MemoBinding

class MainAdapter(private val memoList: List<Memo>,
                  private val spstar : SharedPreferences,
                  private val spheart : SharedPreferences,
                  private val updateMemo: (Memo) -> Unit) : RecyclerView.Adapter<MainAdapter.viewHolder>() {

    inner class viewHolder(val binding: MemoBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(memo: Memo, position: Int) {
            binding.textNo.text = memo.no.toString()
            binding.rvText.text = memo.text
            binding.checkStar.isChecked = memo.checkstar
            binding.checkHeart.isChecked = memo.checkheart

            binding.checkStar.setOnCheckedChangeListener(null)
            binding.checkHeart.setOnCheckedChangeListener(null)

            binding.checkStar.setOnCheckedChangeListener { _, isChecked ->
                memo.checkstar = isChecked
                updateMemo(memo)

                spstar.edit()
                    .putBoolean("checkState_star_$adapterPosition", isChecked)
                    .apply()
            }

            binding.checkHeart.setOnCheckedChangeListener { _, isChecked ->
                memo.checkheart = isChecked
                updateMemo(memo)

                spheart.edit()
                    .putBoolean("checkState_heart_$adapterPosition", isChecked)
                    .apply()
            }

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    Toast.makeText(itemView.context, "${memo.checkheart}, ${memo.checkstar}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = MemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun getItemCount() = memoList.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val memo = memoList[position]

        val checkStateStar = spstar.getBoolean("checkState_star_$position", false)
        memo.checkstar = checkStateStar

        val checkStateHeart = spheart.getBoolean("checkState_heart_$position", false)
        memo.checkheart = checkStateHeart

        holder.bind(memo, position)
    }
}