package com.example.mission3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.mission3.databinding.ActivityMainBinding
import com.example.mission3.databinding.ActivityMissionBinding

class MissionActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMissionBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnBack.setOnClickListener {
            val intent = Intent()
            intent.putExtra(LastActivity.BACK_MESSAGE, "Back")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}