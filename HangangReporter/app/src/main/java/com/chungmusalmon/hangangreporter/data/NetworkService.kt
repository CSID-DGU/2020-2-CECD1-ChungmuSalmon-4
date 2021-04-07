package com.chungmusalmon.hangangreporter.data

import com.chungmusalmon.hangangreporter.data.model.CongestionResponse
import com.chungmusalmon.hangangreporter.data.model.SectionsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {
    @GET("section")
    suspend fun getSections(): SectionsResponse
    @GET("section/{sectionId}/congestion")
    suspend fun getCongestion(@Path("sectionId") sectionId : String): CongestionResponse
}