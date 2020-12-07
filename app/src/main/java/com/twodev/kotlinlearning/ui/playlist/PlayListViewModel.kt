package com.twodev.kotlinlearning.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twodev.kotlinlearning.Repository.Resource
import com.twodev.kotlinlearning.Repository.YoutubeRepository
import com.twodev.kotlinlearning.models.PlayList
import com.twodev.kotlinlearning.models.PlayListItems
import retrofit2.Call


class PlayListViewModel(var youtubeRepository: YoutubeRepository) : ViewModel() {


    fun fetchPlayLists(): LiveData<Resource<PlayList>> {
        return youtubeRepository.fetchPlayListsFromNetwork()
    }






}