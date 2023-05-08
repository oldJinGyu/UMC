package com.example.mission5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mission5_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    val myDataSet = mutableListOf<com.example.mission5_2.Memo>()

    private val startMemoActivityForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK){
            val data = result.data
            val title = data?.getStringExtra("title")
            val memo = data?.getStringExtra("memo")

            if(title != null && memo != null)
                myDataSet.add(Memo(title.toString(), memo.toString()))
        }
    }

    val startReMemoActivityForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK){
            val data = result.data
            val title = data?.getStringExtra("retitle")
            val memo = data?.getStringExtra("rememo")
            val position = data?.getIntExtra("position", 0)

            if(title != null && memo != null && position != null) {
                // 위치에 해당하는 Memo 객체를 수정
                myDataSet[position] = Memo(title.toString(), memo.toString())
                // 어댑터에 데이터셋이 변경되었음을 알림
                viewBinding.rvMain.adapter?.notifyItemChanged(position)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.plusBtn.setOnClickListener {
            val intent = Intent(this, MemoActivity::class.java)
            startMemoActivityForResult.launch(intent)
        }

        val recyclerView = viewBinding.rvMain

        recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = MemoAdapter(myDataSet)

    }
}
