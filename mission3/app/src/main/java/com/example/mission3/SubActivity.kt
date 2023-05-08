package com.example.mission3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mission3.databinding.ActivityMainBinding
import com.example.mission3.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val extras = intent.extras
        val text = extras!!["edtext"] as String

        viewBinding.subtext.text = text

        viewBinding.btn2.setOnClickListener {
            val intent = Intent(this, LastActivity::class.java)
            startActivity(intent)
        }
    }


}