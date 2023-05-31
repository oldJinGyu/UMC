package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.databinding.ActivityParkBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParkActivity : AppCompatActivity() {

    private val binding : ActivityParkBinding by lazy { ActivityParkBinding.inflate(layoutInflater)}
    var parkingList = listOf<Row2>()
    lateinit var listAdapter2 : ListAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        listAdapter2 = ListAdapter2()

        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        binding.recycler02.addItemDecoration(dividerItemDecoration)

        binding.btn02.setOnClickListener {
            listAdapter2.setList(parkingList)
            listAdapter2.notifyDataSetChanged()
        }

        binding.recycler02.apply {
            adapter = listAdapter2
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
        initList()
    }
    private fun initList() {
        val call = ApiObject2.getRetrofitService.getParking(BuildConfig.API_KEY, "json", "GetParkInfo", 1, 30)
        call.enqueue(object : Callback<Parking> {
            override fun onResponse(call: Call<Parking>, response: Response<Parking>) {
                if (response.isSuccessful) {
                    Toast.makeText(applicationContext, "Call Success", Toast.LENGTH_SHORT).show()
                    val apiResponse = response.body()
                    val getParkInfo = apiResponse?.getParkInfo
                    parkingList = getParkInfo?.row ?: listOf()
                    Log.d("성공", parkingList.toString())
                }
            }

            override fun onFailure(call: Call<Parking>, t: Throwable) {
                val errorMessage = "Call Failed: ${t.message}"
                Log.d("Retrofit", errorMessage)
            }
        })
    }
}