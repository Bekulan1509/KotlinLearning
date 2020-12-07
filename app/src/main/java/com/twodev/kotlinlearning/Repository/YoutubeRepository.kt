package com.twodev.kotlinlearning.Repository

import android.util.Log
import androidx.lifecycle.liveData
import com.twodev.kotlinlearning.data.locale.DetailPlayListDao
import com.twodev.kotlinlearning.data.locale.PlayListDao
import com.twodev.kotlinlearning.data.network.YoutubeApi
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class YoutubeRepository(private var api:YoutubeApi, private var playListDao: PlayListDao,private var detailPlayListDao: DetailPlayListDao) {

    private var part: String? = null
    private var key = "AIzaSyCFKTDYFDNxQ7CustuKGvfbzWWDgSzOKYQ"
    private var id: String? = null


    fun fetchPlayListDetailFromNetwork(playListDetailId: String?) = liveData(Dispatchers.IO) {
        part = "snippet"
        id = playListDetailId
        emit(Resource.loading(data = null))
        emit(Resource.fetchFromDb(detailPlayListDao.getListDetail()))
        try {
            val request = api.fetPlayListsDetails(part, id, key)
            detailPlayListDao.insertPlayListDetail(request)
            emit(Resource.success(data = request))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: " Error"))
            Log.e("tag1", "fetchPlayListDetailFromNetwork: ${e.printStackTrace()}")
        }
    }



    fun fetchPlayListsFromNetwork() = liveData(Dispatchers.IO) {
        part = "snippet"
        id = "UC3w7ISVGFJw7Ay2kCuc07Cw"
        emit(Resource.loading(data = null))
        emit(Resource.fetchFromDb(playListDao.getList()))
        try {
            val request = api.fetPlayLists(part, id, key)
            emit(Resource.success(data = request))
            playListDao.insertPlayList(request)
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: " Error"))
            Log.e("tag1", "fetchPlayListsFromNetwork: ${e.message}")
        }
    }




}