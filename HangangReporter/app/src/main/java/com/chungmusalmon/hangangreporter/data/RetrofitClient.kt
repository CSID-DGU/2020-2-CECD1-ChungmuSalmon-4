package com.chungmusalmon.hangangreporter.data

import android.util.Log
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var instance : NetworkService? = null

    private const val BASE_URL = "http://20.194.53.249:7070/api/"

    fun getInstance() : NetworkService{
        if(instance == null){

            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService::class.java)
        }
        return instance!!
    }
}