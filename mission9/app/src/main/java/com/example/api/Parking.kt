package com.example.api


import com.google.gson.annotations.SerializedName

data class Parking(
    @SerializedName("GetParkInfo")
    val getParkInfo: GetParkInfo?
)

data class GetParkInfo(
    @SerializedName("list_total_count")
    val listTotalCount: Int?,
    @SerializedName("RESULT")
    val rESULT: RESULT2?,
    @SerializedName("row")
    val row: List<Row2>?
)

data class RESULT2(
    @SerializedName("CODE")
    val cODE: String?,
    @SerializedName("MESSAGE")
    val mESSAGE: String?
)

data class Row2(
    @SerializedName("ADDR")
    val aDDR: String?,
    @SerializedName("ADD_RATES")
    val aDDRATES: Int?,
    @SerializedName("ADD_TIME_RATE")
    val aDDTIMERATE: Int?,
    @SerializedName("BUS_ADD_RATES")
    val bUSADDRATES: Int?,
    @SerializedName("BUS_ADD_TIME_RATE")
    val bUSADDTIMERATE: Int?,
    @SerializedName("BUS_RATES")
    val bUSRATES: Int?,
    @SerializedName("BUS_TIME_RATE")
    val bUSTIMERATE: Int?,
    @SerializedName("CAPACITY")
    val cAPACITY: Int?,
    @SerializedName("DAY_MAXIMUM")
    val dAYMAXIMUM: Int?,
    @SerializedName("FULLTIME_MONTHLY")
    val fULLTIMEMONTHLY: String?,
    @SerializedName("GRP_PARKNM")
    val gRPPARKNM: String?,
    @SerializedName("HOLIDAY_BEGIN_TIME")
    val hOLIDAYBEGINTIME: String?,
    @SerializedName("HOLIDAY_END_TIME")
    val hOLIDAYENDTIME: String?,
    @SerializedName("HOLIDAY_PAY_NM")
    val hOLIDAYPAYNM: String?,
    @SerializedName("HOLIDAY_PAY_YN")
    val hOLIDAYPAYYN: String?,
    @SerializedName("LAT")
    val lAT: Double?,
    @SerializedName("LNG")
    val lNG: Double?,
    @SerializedName("NIGHT_FREE_OPEN")
    val nIGHTFREEOPEN: String?,
    @SerializedName("NIGHT_FREE_OPEN_NM")
    val nIGHTFREEOPENNM: String?,
    @SerializedName("OPERATION_RULE")
    val oPERATIONRULE: String?,
    @SerializedName("OPERATION_RULE_NM")
    val oPERATIONRULENM: String?,
    @SerializedName("PARKING_CODE")
    val pARKINGCODE: String?,
    @SerializedName("PARKING_NAME")
    val pARKINGNAME: String?,
    @SerializedName("PARKING_TYPE")
    val pARKINGTYPE: String?,
    @SerializedName("PARKING_TYPE_NM")
    val pARKINGTYPENM: String?,
    @SerializedName("PAY_NM")
    val pAYNM: String?,
    @SerializedName("PAY_YN")
    val pAYYN: String?,
    @SerializedName("QUE_STATUS")
    val qUESTATUS: String?,
    @SerializedName("QUE_STATUS_NM")
    val qUESTATUSNM: String?,
    @SerializedName("RATES")
    val rATES: Int?,
    @SerializedName("SATURDAY_PAY_NM")
    val sATURDAYPAYNM: String?,
    @SerializedName("SATURDAY_PAY_YN")
    val sATURDAYPAYYN: String?,
    @SerializedName("SYNC_TIME")
    val sYNCTIME: String?,
    @SerializedName("TEL")
    val tEL: String?,
    @SerializedName("TIME_RATE")
    val tIMERATE: Int?,
    @SerializedName("WEEKDAY_BEGIN_TIME")
    val wEEKDAYBEGINTIME: String?,
    @SerializedName("WEEKDAY_END_TIME")
    val wEEKDAYENDTIME: String?,
    @SerializedName("WEEKEND_BEGIN_TIME")
    val wEEKENDBEGINTIME: String?,
    @SerializedName("WEEKEND_END_TIME")
    val wEEKENDENDTIME: String?
)