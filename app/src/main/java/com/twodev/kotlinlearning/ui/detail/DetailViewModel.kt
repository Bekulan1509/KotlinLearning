package com.twodev.kotlinlearning.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.twodev.kotlinlearning.Repository.Resource
import com.twodev.kotlinlearning.Repository.YoutubeRepository
import com.twodev.kotlinlearning.models.DetailPlayList


class DetailViewModel(var repository: YoutubeRepository) : ViewModel() {

    fun fetchPlayListDetails(playListDetailId:String?): LiveData<Resource<DetailPlayList>> {
        return repository.fetchPlayListDetailFromNetwork(playListDetailId)
    }
}