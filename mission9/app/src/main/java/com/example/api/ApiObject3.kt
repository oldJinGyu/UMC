package com.example.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiObject3 {
    private const val BASE_URL = "http://openapi.seoul.go.kr:8088"

    private val getRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getRetrofitService : EventInterface by lazy { getRetrofit.create(EventInterface::class.java) }
}