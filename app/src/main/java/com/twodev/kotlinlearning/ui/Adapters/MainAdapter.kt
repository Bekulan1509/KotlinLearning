package com.twodev.kotlinlearning.ui.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twodev.kotlinlearning.R
import com.twodev.kotlinlearning.loadImage
import com.twodev.kotlinlearning.models.PlayListItems

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var list = mutableListOf<PlayListItems?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
        list[position]?.let { holder.bind(it) }
    }

    fun addItems(items: MutableList<PlayListItems>?) {
        items?.let { list.addAll(it) }
        notifyDataSetChanged()
    }


    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(items: PlayListItems) {
            titleTV.text = items.snippet?.title
            descriptionTV.text = items.snippet?.description
            items.snippet?.thumbnails?.medium?.url?.let { itemImage.loadImage(it)}
        }

       private var descriptionTV: TextView = itemView.findViewById(R.id.item_county_textView)
        private var titleTV: TextView = itemView.findViewById(R.id.item_title_textView)
        private var itemImage: ImageView = itemView.findViewById(R.id.item_image)
    }
}



