package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val recyclerView = viewBinding.recyclerView
        val myDataSet = mutableListOf<com.example.myapplication.UserSwitch>()

        for (i in 1..30) {
            val title = "Item $i"
            val switch = UserSwitch(title, false)
            myDataSet.add(switch)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(myDataSet)

    }

}