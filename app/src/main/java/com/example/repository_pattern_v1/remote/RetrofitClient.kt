package com.example.repository_pattern_v1.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val SERVICE_URL = "https://reqres.in/api/users?page=2"
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}