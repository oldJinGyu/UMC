package com.example.timer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.NumberPicker
import android.widget.SeekBar
import com.example.timer.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySubBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var seekBar: SeekBar
    private val handler = Handler()
    private var isMediaPlayerPrepared = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        seekBar = viewBinding.barM

        mediaPlayer = MediaPlayer.create(this@SubActivity, R.raw.bonvoyage)

        val totalm = mediaPlayer.duration / 60000
        val totals = (mediaPlayer.duration % 60000) / 1000

        viewBinding.mtotal.text = "${totalm}:${totals}"

        mediaPlayer.setOnPreparedListener {
            isMediaPlayerPrepared = true
            seekBar.max = mediaPlayer.duration
            mediaPlayer.start()
            updateSeekBar()
        }

        mediaPlayer.setOnCompletionListener {
            mediaPlayer.reset()
            seekBar.progress = 0
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        viewBinding.btnMstart.setOnClickListener {
            if (!isMediaPlayerPrepared) {
                mediaPlayer.prepareAsync()
                mediaPlayer.setOnPreparedListener {
                    isMediaPlayerPrepared = true
                    mediaPlayer.start()
                    updateSeekBar()
                }
            } else {
                mediaPlayer.start()
                updateSeekBar()
            }
        }

        viewBinding.btnMstop.setOnClickListener {
            if (isMediaPlayerPrepared) {
                mediaPlayer.pause()
                handler.removeCallbacksAndMessages(null)
            }
        }
        viewBinding.btnMend.setOnClickListener {
            if (isMediaPlayerPrepared) {
                mediaPlayer.stop()
                isMediaPlayerPrepared = false
                viewBinding.mnow.text = "0:0"
                seekBar.progress = 0
            }
        }
    }

    private fun updateSeekBar() {
        seekBar.progress = mediaPlayer.currentPosition
        var nowm = mediaPlayer.currentPosition / 60000
        var nows = (mediaPlayer.currentPosition % 60000) / 1000
        viewBinding.mnow.text = "${nowm}:${nows}"
        if (mediaPlayer.isPlaying) {
            handler.postDelayed({ updateSeekBar() }, 100)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
        handler.removeCallbacksAndMessages(null)
    }
}


