package com.twodev.kotlinlearning.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twodev.kotlinlearning.models.PlayListItems

open class BaseViewModel : ViewModel() {
    var errorMessage = MutableLiveData<String?>()


}