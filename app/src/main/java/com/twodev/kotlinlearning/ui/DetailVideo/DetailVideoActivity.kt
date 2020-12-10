package com.twodev.kotlinlearning.ui.DetailVideo

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.twodev.kotlinlearning.R
import com.twodev.kotlinlearning.base.BaseActivity
import com.twodev.kotlinlearning.base.BaseViewModel
import com.twodev.kotlinlearning.ui.DetailVideo.adapter.DetailVideoAdapter
import com.twodev.kotlinlearning.ui.playlist.PlayListViewModel
import com.twodev.kotlinlearning.ui.playlist.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_detail_video.*
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class DetailVideoActivity : BaseActivity<BaseViewModel>(R.layout.activity_detail_video) {


    override val viewModel by inject<DetailVideoViewModel>()
    lateinit var adapter: DetailVideoAdapter

    override fun setupViews() {
        setupAdapter()
    }

    override fun setupLiveData() {
        getupData()
    }

    private fun getupData() {
        viewModel.players.observeForever {
            adapter.addItems(it)
            Log.d("tag1", "getupDataDetailVideoActivity: ${it.toString()}")
        }
    }

    private fun setupAdapter() {
        adapter = DetailVideoAdapter()
        recycler_view_video.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view_video.adapter = adapter
    }
}