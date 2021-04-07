package com.chungmusalmon.hangangreporter.domain.repository

import com.chungmusalmon.hangangreporter.data.model.CongestionResponse
import com.chungmusalmon.hangangreporter.data.model.SectionsResponse
import com.chungmusalmon.hangangreporter.viewmodel.model.Section

interface SectionRepository {
    suspend fun getSectionList() : MutableList<SectionsResponse.Section>?
    suspend fun getCongestion(id : String) : Int?
}