package com.chungmusalmon.hangangreporter.data.source

import com.chungmusalmon.hangangreporter.data.NetworkService
import com.chungmusalmon.hangangreporter.data.model.CongestionResponse
import com.chungmusalmon.hangangreporter.data.model.SectionsResponse

class SectionDataSource(private val api : NetworkService) {
    suspend fun getSectionList() : SectionsResponse = api.getSections()
    suspend fun getCongestion(sectionId : String) : CongestionResponse = api.getCongestion(sectionId)
}