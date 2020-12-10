package com.twodev.kotlinlearning.di

import com.twodev.kotlinlearning.data.Repository.YoutubeRepository
import com.twodev.kotlinlearning.data.network.instanceRetrofit
import com.twodev.kotlinlearning.models.provideDb
import com.twodev.kotlinlearning.models.provideDetailPlayListDao
import com.twodev.kotlinlearning.models.providePlayListDao
import com.twodev.kotlinlearning.ui.DetailVideo.DetailVideoViewModel
import com.twodev.kotlinlearning.ui.detail.DetailViewModel
import com.twodev.kotlinlearning.ui.playlist.PlayListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.prefs.Preferences


var viewModuleModule = module {
    viewModel { PlayListViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { DetailVideoViewModel(get()) }
}

var networkModule = module {
    single {instanceRetrofit() }
}

var repositoryModule = module {
    factory { YoutubeRepository(get(),get(),get()) }
}

var dbModule = module {
    single { provideDb(androidContext()) }
    single { providePlayListDao(get()) }
    single { provideDetailPlayListDao(get()) }
}

var sharedPreference = module {

}