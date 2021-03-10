package com.chungmusalmon.hangangreporter.data.repository

import com.chungmusalmon.hangangreporter.data.model.CongestionResponse
import com.chungmusalmon.hangangreporter.data.model.SectionsResponse
import com.chungmusalmon.hangangreporter.data.source.SectionDataSource
import com.chungmusalmon.hangangreporter.domain.repository.SectionRepository

class SectionRepositoryImpl(private val sectionDataSource: SectionDataSource) : SectionRepository{
    override suspend fun getSectionList(): SectionsResponse = sectionDataSource.getSectionList()
    override suspend fun getCongestion(id: String): CongestionResponse = sectionDataSource.getCongestion(id)

}

