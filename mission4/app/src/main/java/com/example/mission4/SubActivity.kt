package com.example.mission4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mission4.databinding.ActivityMainBinding
import com.example.mission4.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.textSub.setText(intent.getStringExtra("memo"))
    }
}