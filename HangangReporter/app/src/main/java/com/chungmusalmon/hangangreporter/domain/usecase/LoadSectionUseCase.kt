package com.chungmusalmon.hangangreporter.domain.usecase

import android.util.Log
import com.chungmusalmon.hangangreporter.domain.mapper.SectionMapper
import com.chungmusalmon.hangangreporter.domain.repository.SectionRepository
import com.chungmusalmon.hangangreporter.viewmodel.model.Section

class LoadSectionUseCase(private val sectionRepository: SectionRepository) {
    suspend fun build() : ArrayList<Section>{
        val result = ArrayList<Section>()
        for(section in sectionRepository.getSectionList()!!){
            Log.e("test", "test2")
            result.add(SectionMapper.fromData(section, sectionRepository.getCongestion(section.id)?:0))
        }
        return result
    }
}