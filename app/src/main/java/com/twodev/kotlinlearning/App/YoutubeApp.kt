package com.twodev.kotlinlearning.App

import android.app.Application
import android.content.Context
import com.twodev.kotlinlearning.data.network.YoutubeApi
import com.twodev.kotlinlearning.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class YoutubeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidLogger()
            androidContext(this@YoutubeApp)
            modules(
                listOf(
                    networkModule, viewModuleModule, repositoryModule, dbModule
                )
            )
        }
    }

    fun setLanguagePref(localeKey: String) {
        val pref = getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit()
        pref.putString(LOCALE,localeKey)
        pref.apply()
    }

    fun getLanguagePref(): String? {
        val pref = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        return pref.getString(LOCALE, "rus")
    }

    companion object {
        var instance: YoutubeApp? = null
        const val PREFS: String = "SHARED_PREFS"
        const val LOCALE: String = "LOCALE"
    }
}