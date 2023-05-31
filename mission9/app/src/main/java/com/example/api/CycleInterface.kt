package com.example.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CycleInterface {
    @GET("/{key}/{type}/{service}/{startIndex}/{endIndex}/")
    fun getCycle(
        @Path("key") key: String,
        @Path("type") type: String,
        @Path("service") service: String,
        @Path("startIndex") startIndex: Int,
        @Path("endIndex") endIndex: Int,
    ): Call<ApiResponse>
}