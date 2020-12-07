package com.twodev.kotlinlearning.data.locale

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.twodev.kotlinlearning.models.PlayList

@Dao
interface PlayListDao {
    @Query("SELECT*FROM playList")
    suspend fun getList(): PlayList

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayList(items: PlayList)
}