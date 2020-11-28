package com.twodev.kotlinlearning.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twodev.kotlinlearning.data.network.RetrofitClient
import com.twodev.kotlinlearning.data.network.YoutubeApi
import com.twodev.kotlinlearning.models.PlayList
import retrofit2.Call
import retrofit2.Response

class YoutubeRepository {


    private var api: YoutubeApi = RetrofitClient.instanceRetrofit()

    val data = MutableLiveData<PlayList?>()
    private var part = "snippet"
    private var key = "AIzaSyCFKTDYFDNxQ7CustuKGvfbzWWDgSzOKYQ"
    private var channelId = "UCeObZv89Stb2xLtjLJ0De3Q"



    fun fetchPlayListsFromNetwork(): MutableLiveData<PlayList?> {
        api.fetPlayLists(part, key, channelId,null).enqueue(object : retrofit2.Callback<PlayList?> {
            override fun onResponse(call: Call<PlayList?>, response: Response<PlayList?>) {
                data.value = response.body()
                Log.d("tag1", "onResponse: everything is great")
            }

            override fun onFailure(call: Call<PlayList?>, t: Throwable) {
                data.value = null
                Log.e("tag1", "onFailure: ",t)
            }

        })
        return data
    }
}