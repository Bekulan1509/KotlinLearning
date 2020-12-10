package com.twodev.kotlinlearning.App

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import java.util.*

object LocaleManager {
    fun setLocale(mContext: Context): Context {
        return if (YoutubeApp.instance!!.getLanguagePref() != null) {
            Log.d("tag1", "setLocale: true ")
            updateResources(mContext, YoutubeApp.instance!!.getLanguagePref()!!)
        }
        else{
            Log.d("tag1", "setLocale: false ")
            mContext
        }
    }

    fun setNewLocale(mContext: Context,languagePref: String): Context{
        YoutubeApp.instance!!.setLanguagePref(languagePref)
        Log.d("tag1", "setNewLocale: $languagePref  ")
        return updateResources(mContext,languagePref)
    }

    private fun updateResources(mContext: Context, languagePref: String): Context {
        var localContext = mContext
        val locale = Locale(languagePref)
        Locale.setDefault(locale)
        val res = mContext.resources
        val config = Configuration(res.configuration)
        config.setLocale(locale)
        localContext = mContext.createConfigurationContext(config)
        Log.d("tag1", "updateResources:${localContext} ")
        return localContext
    }
}