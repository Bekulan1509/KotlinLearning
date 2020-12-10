package com.twodev.kotlinlearning.ui.DetailVideo

import androidx.lifecycle.MutableLiveData
import com.twodev.kotlinlearning.data.Repository.Status
import com.twodev.kotlinlearning.data.Repository.YoutubeRepository
import com.twodev.kotlinlearning.base.BaseViewModel
import com.twodev.kotlinlearning.models.PlayListItems
import com.twodev.kotlinlearning.models.PlayerItems


class DetailVideoViewModel(private var youtubeRepository: YoutubeRepository) : BaseViewModel() {

    var players = MutableLiveData<MutableList<PlayerItems>?>()

    init {
        fetchPlayLists()
    }

    fun fetchPlayLists() {
        youtubeRepository.fetchPlayersFromNetwork().observeForever {
            when(it.status){
                Status.SUCCESS -> players.postValue(it.data?.items)
                Status.ERROR -> errorMessage.postValue(it.message.toString())
            }
        }
    }

}