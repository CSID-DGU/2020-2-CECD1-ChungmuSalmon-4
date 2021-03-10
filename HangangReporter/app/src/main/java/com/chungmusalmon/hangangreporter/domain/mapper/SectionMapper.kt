package com.chungmusalmon.hangangreporter.domain.mapper

import com.chungmusalmon.hangangreporter.data.model.SectionsResponse
import com.chungmusalmon.hangangreporter.viewmodel.model.Section

object SectionMapper {
    fun fromData(section: SectionsResponse.Section, congestion : Int) : Section = Section(section.id, section.description, section.centerLongitude, section.centerLatitude, congestion)

}