package com.twodev.kotlinlearning.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val BASE_URL = "https://www.googleapis.com/"

class RetrofitClient {
    companion object {
        private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .writeTimeout(40, TimeUnit.SECONDS)
            .build()

         private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        fun instanceRetrofit(): YoutubeApi {
            return retrofit.create(YoutubeApi::class.java)
        }
    }
}