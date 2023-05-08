package com.example.mission5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mission5_2.databinding.ActivityRememoBinding


class ReMemoActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityRememoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRememoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val title = intent.getStringExtra("title")
        val memo = intent.getStringExtra("memo")
        val position = intent.getIntExtra("position", 0)

        viewBinding.editRetitle.setText(title)
        viewBinding.editRememo.setText(memo)

        viewBinding.refinishBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val title = viewBinding.editRetitle.text.toString()
            val memo = viewBinding.editRememo.text.toString()
            intent.putExtra("retitle", title)
                .putExtra("rememo", memo)
                .putExtra("position", position)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
