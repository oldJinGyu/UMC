package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.databinding.ActivityEventBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventActivity : AppCompatActivity() {

    private val binding : ActivityEventBinding by lazy { ActivityEventBinding.inflate(layoutInflater)}
    var eventList = listOf<Row3>()
    lateinit var listAdapter3 : ListAdapter3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listAdapter3 = ListAdapter3()

        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        binding.recycler03.addItemDecoration(dividerItemDecoration)

        binding.btn03.setOnClickListener {
            listAdapter3.setList(eventList)
            listAdapter3.notifyDataSetChanged()
        }

        binding.recycler03.apply {
            adapter = listAdapter3
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
        initList()
    }
    private fun initList() {
        val call = ApiObject3.getRetrofitService.getEvent(BuildConfig.API_KEY, "json", "culturalEventInfo", 1, 50)
        call.enqueue(object : Callback<Event> {
            override fun onResponse(call: Call<Event>, response: Response<Event>) {
                Toast.makeText(applicationContext, "Call Success", Toast.LENGTH_SHORT).show()
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val culturalEventInfo = apiResponse?.culturalEventInfo
                    eventList = culturalEventInfo?.row3 ?: listOf()
                    Log.d("성공", eventList.toString())
                }
            }

            override fun onFailure(call: Call<Event>, t: Throwable) {
                val errorMessage = "Call Failed: ${t.message}"
                Log.d("Retrofit", errorMessage)
            }
        })
    }
}