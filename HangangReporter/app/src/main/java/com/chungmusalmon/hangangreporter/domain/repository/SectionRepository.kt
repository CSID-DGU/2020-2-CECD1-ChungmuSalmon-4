package com.chungmusalmon.hangangreporter.domain.repository

import com.chungmusalmon.hangangreporter.data.model.CongestionResponse
import com.chungmusalmon.hangangreporter.data.model.SectionsResponse

interface SectionRepository {
    suspend fun getSectionList() : SectionsResponse
    suspend fun getCongestion(id : String) : CongestionResponse
}