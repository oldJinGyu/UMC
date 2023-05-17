package com.example.timer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import com.example.timer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    var m : Int = 0
    var s : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnStart.isEnabled = false
        viewBinding.btnStart.alpha = 0.5f

        val numberpickerm : NumberPicker = viewBinding.numM
        val numberpickers : NumberPicker = viewBinding.numS

        val formatter = NumberPicker.Formatter { value -> String.format("%02d", value) }

        numberpickerm.setFormatter(formatter)
        numberpickers.setFormatter(formatter)

        numberpickerm.minValue = 0
        numberpickerm.maxValue = 60

        numberpickers.minValue = 0
        numberpickers.maxValue = 59

        numberpickerm.value = 0
        numberpickers.value = 0

        numberpickerm.setOnValueChangedListener { picker, _, newVal ->
            m = newVal
            buttonUpdate()
        }

        numberpickers.setOnValueChangedListener { picker, _, newVal ->
            s = newVal
            buttonUpdate()
        }

        viewBinding.btnStart.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
            intent.putExtra("m", m)
            intent.putExtra("s", s)
            startActivity(intent)
        }

        viewBinding.btnNext.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }

    private fun buttonUpdate() {
        if(m == 0 && s == 0) {
            viewBinding.btnStart.isEnabled = false
            viewBinding.btnStart.alpha = 0.5f
        } else {
            viewBinding.btnStart.isEnabled = true
            viewBinding.btnStart.alpha = 1f
        }
    }
}