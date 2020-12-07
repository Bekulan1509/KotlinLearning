package com.twodev.kotlinlearning.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.twodev.kotlinlearning.models.DetailPlayList
import com.twodev.kotlinlearning.models.PlayList
import com.twodev.kotlinlearning.models.converter.DetailItemsConverter
import com.twodev.kotlinlearning.models.converter.PlayListItemsConverter

@Database(entities = [PlayList::class,DetailPlayList::class], version = 1)
@TypeConverters(PlayListItemsConverter::class,DetailItemsConverter::class)
abstract class AppDatabase() : RoomDatabase() {
  abstract fun playListDao(): PlayListDao
  abstract fun detailPlayListDao(): DetailPlayListDao
}