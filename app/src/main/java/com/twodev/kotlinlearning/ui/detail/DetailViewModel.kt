package com.twodev.kotlinlearning.ui.detail

import androidx.lifecycle.MutableLiveData
import com.twodev.kotlinlearning.data.Repository.Status
import com.twodev.kotlinlearning.data.Repository.YoutubeRepository
import com.twodev.kotlinlearning.base.BaseViewModel
import com.twodev.kotlinlearning.models.DetailItems


class DetailViewModel(var repository: YoutubeRepository) : BaseViewModel() {
    var details = MutableLiveData<MutableList<DetailItems>>()



    fun fetchPlayListDetails(playListDetailId: String?) {
        repository.fetchPlayListDetailFromNetwork(playListDetailId).observeForever {
            when (it.status) {
                Status.SUCCESS -> details.postValue(it.data?.items!!)
                Status.ERROR -> errorMessage.postValue(it.message.toString())
            }
        }
    }
}