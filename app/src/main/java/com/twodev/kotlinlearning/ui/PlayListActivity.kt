package com.twodev.kotlinlearning.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.twodev.kotlinlearning.R
import com.twodev.kotlinlearning.ui.Adapters.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class PlayListActivity : AppCompatActivity() {

    lateinit var viewModel: PlayListViewModel

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(PlayListViewModel::class.java)
        setUpAdapter()
        setUpData()
    }

    private fun setUpData() {
        viewModel.fetchPlayLists().observe(this, Observer {
            adapter.addItems(it?.items)
            Log.d("tag1", "setUpData: $it")

        })
    }




    private fun setUpAdapter() {
        adapter = MainAdapter()
        recycler_view.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = adapter

    }


}



