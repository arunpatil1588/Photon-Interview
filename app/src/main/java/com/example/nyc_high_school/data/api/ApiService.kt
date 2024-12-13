package com.example.nyc_high_school.data.api

import com.example.nyc_high_school.data.model.HighSchool
import com.example.nyc_high_school.data.model.SATScore
import retrofit2.http.GET

interface ApiService {
    @GET("s3k6-pzi2.json")
    suspend fun getSchools(): List<HighSchool>

    @GET("f9bf-2cp4.json")
    suspend fun getSatScores(): List<SATScore>
}