package com.chungmusalmon.hangangreporter.di

import com.chungmusalmon.hangangreporter.data.repository.SectionRepositoryImpl
import com.chungmusalmon.hangangreporter.domain.usecase.LoadSectionUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoadSectionUseCase(SectionRepositoryImpl()) }
}
