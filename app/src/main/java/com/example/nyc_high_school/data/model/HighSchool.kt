package com.example.nyc_high_school.data.model

import com.google.gson.annotations.SerializedName

data class HighSchool(

    @SerializedName("dbn") val dbn: String,
    @SerializedName("school_name") val name: String,
    @SerializedName("location") val location: String?,
    @SerializedName("phone_number") val phoneNumber: String?,
    @SerializedName("website") val website: String?,
    @SerializedName("overview_paragraph") val overview: String?
)
