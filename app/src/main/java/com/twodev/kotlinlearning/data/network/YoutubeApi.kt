package com.twodev.kotlinlearning.data.network

import com.twodev.kotlinlearning.models.PlayList
import com.twodev.kotlinlearning.models.PlayListDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface YoutubeApi {
    @GET("youtube/v3/playlists")
   suspend fun fetPlayLists(
        @Query("part") part:String?,
        @Query("channelId") channelId:String?,
        @Query("key") key:String?,
    ):PlayList

    @GET("youtube/v3/playlistItems")
    suspend fun fetPlayListsDetails(
        @Query("part") part:String?,
        @Query("playlistId") playlistId:String?,
        @Query("key") key:String?,
    ):PlayList


}