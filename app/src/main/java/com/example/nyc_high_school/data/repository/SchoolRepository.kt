package com.example.nyc_high_school.data.repository

import com.example.nyc_high_school.data.api.ApiService
import com.example.nyc_high_school.data.model.HighSchool
import com.example.nyc_high_school.data.model.SATScore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchoolRepository @Inject constructor(private val api: ApiService) {
    suspend fun getSchools(): List<HighSchool> = api.getSchools()
    suspend fun getSatScores(): List<SATScore> = api.getSatScores()
}