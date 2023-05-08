package com.example.mission4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.mission4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private var memoText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnMain.setOnClickListener {
            memoText = viewBinding.edtMain.text.toString()
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("memo", viewBinding.edtMain.text.toString())
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        if(memoText.isNotEmpty())
            viewBinding.edtMain.setText(memoText)
    }

    override fun onPause() {
        super.onPause()
        memoText = viewBinding.edtMain.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        val dialog = AlertDialog.Builder(this)
            .setTitle("메모 작성 중입니다")
            .setMessage("이어서 작성하시겠습니까?")
            .setPositiveButton("예") { _, _ ->
                // 다시 작성하기로 결정한 경우, 아무런 작업 없이 다시 SubActivity로 이동합니다.
            }
            .setNegativeButton("아니오") { _, _ ->
                // 다시 작성하지 않기로 결정한 경우, memoText 변수를 비웁니다.
                memoText = ""
                viewBinding.edtMain.setText(" ")
            }
            .create()
        dialog.show()
    }
}