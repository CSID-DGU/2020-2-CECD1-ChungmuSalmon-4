package com.chungmusalmon.hangangreporter

import android.app.Application
import com.chungmusalmon.hangangreporter.di.useCaseModule
import com.chungmusalmon.hangangreporter.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(
                listOf(
                    viewModelModule,
                    useCaseModule
                )
            )
        }

        super.onCreate()
    }
}