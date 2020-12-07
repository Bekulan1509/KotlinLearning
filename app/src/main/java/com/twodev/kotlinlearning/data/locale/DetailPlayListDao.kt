package com.twodev.kotlinlearning.data.locale

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.twodev.kotlinlearning.models.DetailPlayList

@Dao
interface DetailPlayListDao {
    @Query("SELECT*FROM detail")
    suspend fun getListDetail(): DetailPlayList

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayListDetail(items: DetailPlayList)
}