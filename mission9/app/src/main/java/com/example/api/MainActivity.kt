package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var cycleList = listOf<Row>()
    lateinit var listAdapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listAdapter = ListAdapter()

        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        binding.recycler01.addItemDecoration(dividerItemDecoration)

        binding.btn01.setOnClickListener {
            listAdapter.setList(cycleList)
            listAdapter.notifyDataSetChanged()
        }

        binding.recycler01.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
        initList()
    }

    private fun initList() {
        val call = ApiObject.getRetrofitService.getCycle(BuildConfig.API_KEY, "json", "bikeList", 1, 100)
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                Toast.makeText(applicationContext, "Call Success", Toast.LENGTH_SHORT).show()
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    val rentBikeStatus = apiResponse?.rentBikeStatus
                    cycleList = rentBikeStatus?.rows ?: listOf()
                    Log.d("성공", cycleList.toString())
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                val errorMessage = "Call Failed: ${t.message}"
                Log.d("Retrofit", errorMessage)
            }
        })
    }
}