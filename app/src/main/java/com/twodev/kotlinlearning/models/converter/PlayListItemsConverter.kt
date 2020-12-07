package com.twodev.kotlinlearning.models.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.twodev.kotlinlearning.models.PlayListItems
import java.lang.reflect.Type

object PlayListItemsConverter {
    private val gson = Gson()
    private val type: Type = object : TypeToken<MutableList<PlayListItems>>() {}.type

    @TypeConverter
    @JvmStatic
    fun playListItemsToString(playListItems: MutableList<PlayListItems>?): String? =
        gson.toJson(playListItems, type)

    @TypeConverter
    @JvmStatic
    fun stringToPlayListItems(playListItems: String?): MutableList<PlayListItems>? =
        gson.fromJson(playListItems, type)
}