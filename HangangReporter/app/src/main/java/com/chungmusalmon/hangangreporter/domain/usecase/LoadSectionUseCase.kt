package com.chungmusalmon.hangangreporter.domain.usecase

import com.chungmusalmon.hangangreporter.domain.mapper.SectionMapper
import com.chungmusalmon.hangangreporter.domain.repository.SectionRepository
import com.chungmusalmon.hangangreporter.viewmodel.model.Section

class LoadSectionUseCase(private val sectionRepository: SectionRepository) {
    suspend fun build() : ArrayList<Section>{
        val result = ArrayList<Section>()
        for(section in sectionRepository.getSectionList().data){
            result.add(SectionMapper.fromData(section, sectionRepository.getCongestion(section.id).congestion))
        }
        return result
    }
}