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

            binding.btnStarOK.setOnClickListener {
                if(memo.checkstar == "OK"){
                    memo.checkstar = "X"
                    spstar.edit()
                        .putBoolean("checkState_star_$adapterPosition", false)
                        .apply()

                    Toast.makeText(itemView.context, "즐겨찾기에서 해제되었습니다.", Toast.LENGTH_SHORT).show()
                }
                else{
                    memo.checkstar = "OK"
                    spstar.edit()
                        .putBoolean("checkState_star_$adapterPosition", true)
                        .apply()

                    Toast.makeText(itemView.context, "즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT).show()
                }
                updateMemo(memo)
            }

            binding.btnHeart.setOnCheckedChangeListener { _, isChecked ->
                memo.checkheart = isChecked
                updateMemo(memo)

                spheart.edit()
                    .putBoolean("checkState_heart_$adapterPosition", isChecked)
                    .apply()
            }
            binding.btnHeart.isChecked = spheart.getBoolean("checkState_heart_$position", false)

            if(!spstar.getBoolean("checkState_star_$position", false)){
                memo.checkstar = "X"
            }
            else{
                memo.checkstar = "OK"
            }
            updateMemo(memo)

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    Toast.makeText(itemView.context, "${memo.checkheart}, ${memo.checkstar}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.viewHolder {
        val binding = MemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun getItemCount() = memoList.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val memo = memoList[position]
        holder.bind(memo, position)
    }
}