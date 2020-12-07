package com.twodev.kotlinlearning.models

import android.content.Context
import androidx.room.Room
import com.twodev.kotlinlearning.data.locale.AppDatabase
import com.twodev.kotlinlearning.data.locale.DetailPlayListDao
import com.twodev.kotlinlearning.data.locale.PlayListDao


fun provideDb(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "app_database"
    ).build()
}
fun providePlayListDao(db:AppDatabase): PlayListDao? =db.playListDao()
fun provideDetailPlayListDao(db:AppDatabase): DetailPlayListDao? =db.detailPlayListDao()

