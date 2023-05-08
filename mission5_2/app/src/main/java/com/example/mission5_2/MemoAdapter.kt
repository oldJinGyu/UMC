package com.example.mission5_2

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mission5_2.databinding.MemoBinding

class MemoAdapter(private val memoList: List<Memo>) : RecyclerView.Adapter<MemoAdapter.viewHolder>() {

    inner class viewHolder(private val binding: MemoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(memo: Memo) {
            binding.mainTitle.text = memo.title
            binding.rvText.text = memo.content

            itemView.setOnLongClickListener {
                val position = absoluteAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // 데이터 리스트에서 아이템 삭제
                    (itemView.context as MainActivity).myDataSet.removeAt(position)
                    // 어댑터에 데이터셋이 변경되었음을 알림
                    notifyItemRemoved(position)
                    return@setOnLongClickListener true
                }
                return@setOnLongClickListener false
            } //미션 중 item롱클릭시 item삭제되게 하는 코드

            itemView.setOnClickListener {
                val position = absoluteAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val intent = Intent(itemView.context, ReMemoActivity::class.java)
                    intent.putExtra("title", (itemView.context as? MainActivity)?.myDataSet?.get(position)?.title)
                    intent.putExtra("memo", (itemView.context as? MainActivity)?.myDataSet?.get(position)?.content)
                    intent.putExtra("position", position)
                    (itemView.context as? MainActivity)?.startReMemoActivityForResult?.launch(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = MemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(memoList[position])
    }

    override fun getItemCount() = memoList.size
}
