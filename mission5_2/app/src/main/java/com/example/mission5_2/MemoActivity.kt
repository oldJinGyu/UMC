package com.example.mission5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.mission5_2.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.finishBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val title = viewBinding.editTitle.text.toString()
            val memo = viewBinding.editMemo.text.toString()
            intent.putExtra("title", title)
                .putExtra("memo", memo)
            setResult(RESULT_OK, intent)
            finish()
        }


    }
}
