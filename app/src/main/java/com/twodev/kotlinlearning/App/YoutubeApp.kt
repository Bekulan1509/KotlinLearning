package com.twodev.kotlinlearning.App

import android.app.Application
import com.twodev.kotlinlearning.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class YoutubeApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@YoutubeApp)
            modules(listOf(networkModule, viewModuleModule,repositoryModule,dbModule))
        }

    }
}