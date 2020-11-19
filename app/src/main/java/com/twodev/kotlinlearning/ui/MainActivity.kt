package com.twodev.kotlinlearning.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.twodev.kotlinlearning.GenerateActivity
import com.twodev.kotlinlearning.R
import com.twodev.kotlinlearning.showToast
import com.twodev.kotlinlearning.ui.Adapters.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var urls = mutableListOf<String>().apply {
        add("https://picsum.photos/200/300?grayscale")
        add("https://picsum.photos/id/237/200/300")
        add("https://picsum.photos/seed/picsum/200/300")
        add("https://picsum.photos/id/237/200/300")
        add("https://picsum.photos/200/300?grayscale")
        add("https://picsum.photos/200/300/?blur=2")
        add("https://picsum.photos/200/300?grayscale")
    }
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpAdapter()
    }

    private fun setUpAdapter() {
        adapter = MainAdapter()
        recycler_view.adapter = adapter
        adapter.addItems(urls)
    }


}



