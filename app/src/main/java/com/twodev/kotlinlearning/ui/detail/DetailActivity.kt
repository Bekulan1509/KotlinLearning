package com.twodev.kotlinlearning.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.twodev.kotlinlearning.R
import com.twodev.kotlinlearning.Repository.Resource
import com.twodev.kotlinlearning.Repository.Status
import com.twodev.kotlinlearning.models.DetailPlayList
import com.twodev.kotlinlearning.ui.detail.Adapter.DetailAdapter
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity() {

    private val viewModel by inject<DetailViewModel>()

    private lateinit var adapter: DetailAdapter
    private lateinit var playListDetails: Resource<DetailPlayList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUpAdapter()
        getUpData()
        setUpData()
    }

    private fun setUpData() {

    }

    private fun setUpAdapter() {
        adapter = DetailAdapter(this::itemClick)
        recycler_view_detail.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view_detail.adapter = adapter

    }

    private fun itemClick(pos: Int) {
        title_detail_textView.text = playListDetails.data?.items?.get(pos)?.snippet?.title
        description_detail_textView.text = playListDetails.data?.items?.get(pos)?.snippet?.description

    }

    private fun getUpData() {
        val getId: String? = intent.getStringExtra("idKey")
        viewModel.fetchPlayListDetails(getId).observe(this, Observer { it ->
            when (it.status) {
                Status.SUCCESS ->
                    it.data?.items?.let { adapter.addItems(it) }

            }
            playListDetails = it
            title_detail_textView.text = it.data?.items?.get(0)?.snippet?.title
            description_detail_textView.text = it.data?.items?.get(0)?.snippet?.description

        })
    }
}


