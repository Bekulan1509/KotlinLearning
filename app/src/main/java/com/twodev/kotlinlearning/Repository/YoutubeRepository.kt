package com.twodev.kotlinlearning.Repository

import android.util.Log
import androidx.lifecycle.liveData
import com.twodev.kotlinlearning.data.network.RetrofitClient
import com.twodev.kotlinlearning.data.network.YoutubeApi
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class YoutubeRepository {


    private var api: YoutubeApi = RetrofitClient.instanceRetrofit()

    private var part: String? = null
    private var key = "AIzaSyCFKTDYFDNxQ7CustuKGvfbzWWDgSzOKYQ"
    private var id: String? = null


    fun fetchPlayListsFromNetwork() = liveData(Dispatchers.IO) {
        part = "snippet"
        id = "UC3w7ISVGFJw7Ay2kCuc07Cw"
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.fetPlayLists(part, id, key)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: " Error"))
            Log.e("tag1", "fetchPlayListsFromNetwork: ", e)
        }
    }

    fun fetchPlayListDetailFromNetwork(playListDetailId: String?) = liveData(Dispatchers.IO) {
        part = "snippet"
        id = playListDetailId
        emit(Resource.loading(data = null))
        try {
            Log.d("tag1", "fetchPlayListDetailFromNetwork: ${id.toString()}")
            emit(Resource.success(data = api.fetPlayListsDetails(part, id, key)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: " Error"))
            Log.e("tag1", "fetchPlayListDetailFromNetwork: ", e)
        }
    }


}