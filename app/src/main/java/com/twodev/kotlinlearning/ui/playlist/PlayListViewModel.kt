package com.twodev.kotlinlearning.ui.playlist

import androidx.lifecycle.MutableLiveData
import com.twodev.kotlinlearning.data.Repository.Status
import com.twodev.kotlinlearning.data.Repository.YoutubeRepository
import com.twodev.kotlinlearning.base.BaseViewModel
import com.twodev.kotlinlearning.models.PlayListItems


class PlayListViewModel(var youtubeRepository: YoutubeRepository) : BaseViewModel() {

    var playlists = MutableLiveData<MutableList<PlayListItems>?>()

    init {
        fetchPlayLists()
    }

     fun fetchPlayLists() {
        youtubeRepository.fetchPlayListsFromNetwork().observeForever {
            when(it.status){
                Status.SUCCESS -> playlists.postValue(it.data?.items)
                Status.ERROR -> errorMessage.postValue(it.message.toString())
            }
        }
    }
}