package com.twodev.kotlinlearning.ui.playlist

import android.content.Intent

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.twodev.kotlinlearning.App.LocaleManager
import com.twodev.kotlinlearning.R
import com.twodev.kotlinlearning.base.BaseActivity
import com.twodev.kotlinlearning.ui.playlist.adapter.MainAdapter
import com.twodev.kotlinlearning.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class PlayListActivity : BaseActivity<PlayListViewModel>(R.layout.activity_main) {

    private lateinit var adapter: MainAdapter


    override val viewModel by inject<PlayListViewModel>()


    override fun setupViews() {
        viewClicked()
        setUpAdapter()
    }


    override fun setupLiveData() {
        setUpData()

    }

    private fun viewClicked(){
        button_change_rus.setOnClickListener{
            LocaleManager.setNewLocale(this,"ru")
            recreate()
            adapter.notifyDataSetChanged()
        }
        button_change_en.setOnClickListener{
            LocaleManager.setNewLocale(this,"en")
            recreate()
            adapter.notifyDataSetChanged()
        }

    }
    private fun setUpData() {
        viewModel.playlists.observeForever {
            adapter.addItems(it)
        }

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
        intent.putExtra("idKey", data)
        Log.d("tag1", "onItemClick: $data")
        startActivity(intent)
    }


}



