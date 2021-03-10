package com.chungmusalmon.hangangreporter.di

import com.chungmusalmon.hangangreporter.data.repository.SectionRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { SectionRepositoryImpl(get()) }
}