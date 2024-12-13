package com.example.nyc_high_school.data.model

import com.google.gson.annotations.SerializedName

data class SATScore(
    @SerializedName("dbn") val dbn: String,
    @SerializedName("school_name") val schoolName: String,
    @SerializedName("sat_critical_reading_avg_score") val readingScore: String?,
    @SerializedName("sat_math_avg_score") val mathScore: String?,
    @SerializedName("sat_writing_avg_score") val writingScore: String?

)