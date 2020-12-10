package com.twodev.kotlinlearning.data.Repository

import android.util.Log

class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> fetchFromDb(data: T): Resource<T> {
            return if (data != null) Resource(status = Status.SUCCESS, data = data, message = null)
            else Resource(status = Status.ERROR, data = data, message = null)
        }

        fun <T> success(data: T): Resource<T> =
            Resource(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> {
            val result: Resource<T> =
                Resource(status = Status.ERROR, data = data, message = message)
            Log.e("tag1", "error resource request: ${result.message}")
            return result
        }

        fun <T> loading(data: T?): Resource<T> =
            Resource(status = Status.LOADING, data = data, message = null)
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}