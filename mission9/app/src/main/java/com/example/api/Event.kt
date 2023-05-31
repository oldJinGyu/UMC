package com.example.api


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("culturalEventInfo")
    val culturalEventInfo: CulturalEventInfo?
)

data class CulturalEventInfo(
    @SerializedName("list_total_count")
    val listTotalCount: Int?,
    @SerializedName("RESULT")
    val rESULT3: RESULT3?,
    @SerializedName("row")
    val row3: List<Row3>?
)

data class RESULT3(
    @SerializedName("CODE")
    val cODE: String?,
    @SerializedName("MESSAGE")
    val mESSAGE: String?
)

data class Row3(
    @SerializedName("CODENAME")
    val cODENAME: String?,
    @SerializedName("DATE")
    val dATE: String?,
    @SerializedName("END_DATE")
    val eNDDATE: String?,
    @SerializedName("ETC_DESC")
    val eTCDESC: String?,
    @SerializedName("GUNAME")
    val gUNAME: String?,
    @SerializedName("MAIN_IMG")
    val mAINIMG: String?,
    @SerializedName("ORG_LINK")
    val oRGLINK: String?,
    @SerializedName("ORG_NAME")
    val oRGNAME: String?,
    @SerializedName("PLACE")
    val pLACE: String?,
    @SerializedName("PLAYER")
    val pLAYER: String?,
    @SerializedName("PROGRAM")
    val pROGRAM: String?,
    @SerializedName("RGSTDATE")
    val rGSTDATE: String?,
    @SerializedName("STRTDATE")
    val sTRTDATE: String?,
    @SerializedName("THEMECODE")
    val tHEMECODE: String?,
    @SerializedName("TICKET")
    val tICKET: String?,
    @SerializedName("TITLE")
    val tITLE: String?,
    @SerializedName("USE_FEE")
    val uSEFEE: String?,
    @SerializedName("USE_TRGT")
    val uSETRGT: String?
)