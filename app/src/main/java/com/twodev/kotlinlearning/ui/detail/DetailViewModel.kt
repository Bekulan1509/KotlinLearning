package com.twodev.kotlinlearning.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twodev.kotlinlearning.Repository.Resource
import com.twodev.kotlinlearning.Repository.YoutubeRepository
import com.twodev.kotlinlearning.models.PlayList
import com.twodev.kotlinlearning.models.PlayListDetail
import com.twodev.kotlinlearning.models.PlayListItems
import com.twodev.kotlinlearning.ui.playlist.PlayListViewModel
import retrofit2.Call


class DetailViewModel : ViewModel() {

    fun fetchPlayListDetails(playListDetailId:String?): LiveData<Resource<PlayList>> {
        return YoutubeRepository().fetchPlayListDetailFromNetwork(playListDetailId)
    }





}