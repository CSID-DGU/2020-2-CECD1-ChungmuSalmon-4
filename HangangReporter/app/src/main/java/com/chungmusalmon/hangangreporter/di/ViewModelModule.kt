package com.chungmusalmon.hangangreporter.di

import com.chungmusalmon.hangangreporter.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
}

