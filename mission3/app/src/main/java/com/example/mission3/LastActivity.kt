package com.example.mission3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.mission3.databinding.ActivityLastBinding
import com.example.mission3.databinding.ActivityMainBinding
import com.example.mission3.databinding.ActivitySubBinding

class LastActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityLastBinding

    companion object {
        const val BACK_MESSAGE = "Back"
    }

    private val startSubActivityForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val message = data?.getStringExtra(BACK_MESSAGE)
            message?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLastBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.frameFragment.id, FirstFragment())
            .commitAllowingStateLoss()

        viewBinding.btnFragment1.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, FirstFragment())
                .commitAllowingStateLoss()
        }

        viewBinding.btnFragment2.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, SecondFragment())
                .commitAllowingStateLoss()
        }

        viewBinding.button3.setOnClickListener {
            val intent = Intent(this, MissionActivity::class.java)
            startSubActivityForResult.launch(intent)
        }


        val message = intent.getStringExtra("message")
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}