package com.example.mission3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.startActivity
import com.example.mission3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        //객체 생성
        val btn1 = viewBinding.btn1
        val ed1 = viewBinding.ed1

        //text담을 변수
        var text: String = ""
        //버튼 비활성화
        btn1.isEnabled = false
        //edittext값 있을 때만 버튼 활성화
        ed1.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int){
                //입력값 담기
                text = ed1.text.toString()
                //값 유무에 따른 활성화 여부
                btn1.isEnabled = text.isNotEmpty() //있다면 true 없다면 false
            }

            override fun afterTextChanged(p0: Editable?){}
        })
        //버튼 이벤트
        btn1.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("edtext",text)
            startActivity(intent)
        }
    }
}
