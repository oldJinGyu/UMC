package com.example.java

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.java.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //화면 출력 XML명시
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val intent = Intent(this,MainActivity_rel::class.java)
            startActivity(intent)
        }
        binding.btn2.setOnClickListener {
            val intent = Intent(this,MainActivity_fra::class.java)
            startActivity(intent)
        }
        binding.btn3.setOnClickListener {
            val intent = Intent(this,MainActivity_tab::class.java)
            startActivity(intent)
        }
        binding.btn4.setOnClickListener {
            val intent = Intent(this,MainActivity_gri::class.java)
            startActivity(intent)
        }
    }
}
