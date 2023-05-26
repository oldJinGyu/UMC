package com.example.mission8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mission8.databinding.ActivityMainBinding
import com.example.mission8.databinding.ActivityStarBinding

class StarActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityStarBinding
    lateinit var starAdapter: StarAdapter
    var starList = mutableListOf<Memo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityStarBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        starList.addAll(MainActivity.helper.memoDao().getStarMemo())

        starAdapter = StarAdapter(starList)

        viewBinding.rvStar.adapter = starAdapter
        viewBinding.rvStar.layoutManager = LinearLayoutManager(this@StarActivity)

    }
}