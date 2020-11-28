package com.twodev.kotlinlearning.data.network

import com.twodev.kotlinlearning.models.PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {
    @GET("youtube/v3/playlists")
    fun fetPlayLists(
        @Query("part") part:String?,
        @Query("key") key:String?,
        @Query("channelId") channelId:String?,
        @Query("maxResult") maxResult: String?,
    ):Call<PlayList>
}