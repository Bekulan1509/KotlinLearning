package com.twodev.kotlinlearning.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twodev.kotlinlearning.Repository.YoutubeRepository
import com.twodev.kotlinlearning.models.PlayList
import com.twodev.kotlinlearning.models.PlayListItems


class PlayListViewModel : ViewModel() {


    fun fetchPlayLists(): MutableLiveData<PlayList?> {
        return YoutubeRepository().fetchPlayListsFromNetwork()
    }





}