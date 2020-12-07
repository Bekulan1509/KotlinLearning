package com.twodev.kotlinlearning.models.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.twodev.kotlinlearning.models.DetailItems
import java.lang.reflect.Type

object DetailItemsConverter {
    private val gson = Gson()
    private val type: Type = object : TypeToken<MutableList<DetailItems>>() {}.type

    @TypeConverter
    @JvmStatic
    fun playListItemsToString(detailItems: MutableList<DetailItems>?): String? =
        gson.toJson(detailItems, type)

    @TypeConverter
    @JvmStatic
    fun stringToPlayListItems(detailItems: String?): MutableList<DetailItems>? =
        gson.fromJson(detailItems, type)
}