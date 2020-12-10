package com.twodev.kotlinlearning.ui.detail

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.twodev.kotlinlearning.R
import com.twodev.kotlinlearning.base.BaseActivity
import com.twodev.kotlinlearning.models.DetailItems
import com.twodev.kotlinlearning.ui.DetailVideo.DetailVideoActivity
import com.twodev.kotlinlearning.ui.detail.Adapter.DetailAdapter
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class DetailActivity : BaseActivity<DetailViewModel>(R.layout.activity_detail) {

    override val viewModel by inject<DetailViewModel>()

    private var getId: String? = null

    private lateinit var adapter: DetailAdapter
    private lateinit var playListDetails: MutableList<DetailItems>

    override fun setupViews() {
        setUpAdapter()
    }

    override fun setupLiveData() {
        getUpData()
    }

    private fun setUpAdapter() {
        adapter = DetailAdapter(this::itemClick)
        recycler_view_detail.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view_detail.adapter = adapter
    }

    private fun itemClick(pos: Int) {

        val intent = Intent(this, DetailVideoActivity::class.java)
        startActivity(intent)

//        title_detail_textView.text = playListDetails[pos].snippet?.title
//        description_detail_textView.text = playListDetails[pos].snippet?.description
    }

    private fun getUpData() {
        getId = intent.getStringExtra("idKey")
        viewModel.fetchPlayListDetails(getId)
        viewModel.details.observe(this, {
            adapter.addItems(it)
            playListDetails = it
            title_detail_textView.text = it[0].snippet?.title
            description_detail_textView.text = it[0].snippet?.description
        })
    }
}


