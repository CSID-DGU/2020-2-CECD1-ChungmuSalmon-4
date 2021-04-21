package com.chungmusalmon.hangangreporter.di

import com.chungmusalmon.hangangreporter.data.repository.SectionRepositoryImpl
import com.chungmusalmon.hangangreporter.domain.repository.SectionRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<SectionRepository> { SectionRepositoryImpl() }
}