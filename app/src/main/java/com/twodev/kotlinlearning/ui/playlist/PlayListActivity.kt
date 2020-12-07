package com.twodev.kotlinlearning.ui.playlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.twodev.kotlinlearning.R
import com.twodev.kotlinlearning.Repository.Status
import com.twodev.kotlinlearning.showToast
import com.twodev.kotlinlearning.ui.playlist.adapter.MainAdapter
import com.twodev.kotlinlearning.ui.detail.DetailActivity
import com.twodev.kotlinlearning.ui.detail.DetailViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class PlayListActivity() : AppCompatActivity() {

    private val viewModel by inject<PlayListViewModel>()

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpAdapter()
        setUpData()
    }

    private fun setUpData() {
        viewModel.fetchPlayLists().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> it.data?.items?.let { result -> adapter.addItems(result) }
                Status.ERROR -> showToast("ERROR is ERROR)")
            }
        })
    }


    private fun setUpAdapter() {
        adapter = MainAdapter(this::onItemClick)
        recycler_view.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = adapter

    }

    private fun onItemClick(pos: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        val data = adapter.list[pos]?.id
        intent.putExtra("idKey",data)
        Log.d("tag1", "onItemClick: $data")
        startActivity(intent)
    }
}



