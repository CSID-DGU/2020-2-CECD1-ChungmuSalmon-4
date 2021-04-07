package com.chungmusalmon.hangangreporter.data.repository

import android.util.Log
import com.chungmusalmon.hangangreporter.data.RetrofitClient
import com.chungmusalmon.hangangreporter.data.model.SectionsResponse
import com.chungmusalmon.hangangreporter.domain.repository.SectionRepository

class SectionRepositoryImpl : SectionRepository{
    override suspend fun getSectionList(): MutableList<SectionsResponse.Section> = RetrofitClient.getInstance().getSections().data.toMutableList()
    override suspend fun getCongestion(id: String): Int = RetrofitClient.getInstance().getCongestion(id).congestionLevel

}

