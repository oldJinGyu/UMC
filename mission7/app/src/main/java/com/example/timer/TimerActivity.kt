package com.example.timer

import android.content.Intent
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.example.timer.databinding.ActivityTimerBinding
import kotlin.concurrent.thread

class TimerActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityTimerBinding
    private lateinit var progressBar: ProgressBar
    private var isRunning = true
    private lateinit var soundPool: SoundPool
    private var soundId: Int = 0

    var m = 0
    var s = 0
    var total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        soundPool = SoundPool.Builder()
            .setMaxStreams(1)
            .build()

        soundId = soundPool.load(this, R.raw.success, 1)

        val receivedIntent = intent
        if (receivedIntent != null) {
            m = receivedIntent.getIntExtra("m", 0)
            s = receivedIntent.getIntExtra("s", 0)
        }

        progressBar = viewBinding.progressBar

        total = m * 60 + s
        timer_text()
        run()
        progressBar.max = total

        viewBinding.btnStop.setOnClickListener {
            viewBinding.btnStop.visibility = View.INVISIBLE
            viewBinding.btnGo.visibility = View.VISIBLE
            pause()
        }

        viewBinding.btnGo.setOnClickListener {
            viewBinding.btnStop.visibility = View.VISIBLE
            viewBinding.btnGo.visibility = View.INVISIBLE
            run()
        }

        viewBinding.btnCancel.setOnClickListener { cancel() }
    }

    private fun run() {
        isRunning = true
        thread(start=true) {
            while(true) {
                Thread.sleep(1000)
                if(!isRunning) break
                if(total != 0)
                    total -= 1
                if(total == 0) {
                    soundPool.play(soundId, 1.0f, 1.0f, 0, 2, 1.0f)
                    isRunning = false
                }
                runOnUiThread{
                    timer_text()
                    if (total == 0) goback()
                }
            }
        }
    }
    private fun pause() {
        isRunning = false
    }

    private fun cancel() {
        isRunning = false
        goback()
    }

    private fun timer_text() {

        var tm = total/60
        var ts = total%60
        var tm2 = String.format("%02d", tm)
        var ts2 = String.format("%02d", ts)

        if (m>=0)
            viewBinding.textTimer.text = "${tm2}:${ts2}"
        else
            viewBinding.textTimer.text = "${ts2}"

        progressBar.progress = total
    }

    private fun goback(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }
}