package com.example.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ParkingInterface {
    @GET("/{key}/{type}/{service}/{startIndex}/{endIndex}/")
    fun getParking(
        @Path("key") key: String,
        @Path("type") type: String,
        @Path("service") service: String,
        @Path("startIndex") startIndex: Int,
        @Path("endIndex") endIndex: Int,
    ): Call<Parking>
}