package com.example.nyc_high_school.di

import com.example.nyc_high_school.data.api.ApiService
import com.example.nyc_high_school.data.repository.SchoolRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent :: class)
object RetrofitModule {

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS) // Connection timeout
        .readTimeout(60, TimeUnit.SECONDS)    // Read timeout
        .writeTimeout(60, TimeUnit.SECONDS)   // Write timeout
        .build()

    @Provides
    fun provideRetrofit():
            Retrofit = Retrofit.Builder()
        .baseUrl("https://data.cityofnewyork.us/resource/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    @Provides
    @Singleton
    fun provideSchoolApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSchoolRepository(api: ApiService): SchoolRepository {
        return SchoolRepository(api)
    }

}