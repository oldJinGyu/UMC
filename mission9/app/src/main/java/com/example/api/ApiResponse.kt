package com.example.api

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("rentBikeStatus")
    val rentBikeStatus: RentBikeStatus?
)

data class RentBikeStatus(
    @SerializedName("list_total_count")
    val listTotalCount: Int?,
    @SerializedName("RESULT")
    val result: Result?,
    @SerializedName("row")
    val rows: List<Row>?
)

data class Result(
    @SerializedName("CODE")
    val code: String?,
    @SerializedName("MESSAGE")
    val message: String?
)

data class Row(
    @SerializedName("rackTotCnt")
    val rackTotCnt: String?,
    @SerializedName("stationName")
    val stationName: String?,
    @SerializedName("parkingBikeTotCnt")
    val parkingBikeTotCnt: String?,
    @SerializedName("shared")
    val shared: String?,
    @SerializedName("stationLatitude")
    val stationLatitude: String?,
    @SerializedName("stationLongitude")
    val stationLongitude: String?,
    @SerializedName("stationId")
    val stationId: String?
)