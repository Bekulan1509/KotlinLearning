package com.twodev.kotlinlearning.ui.DetailVideo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twodev.kotlinlearning.R
import com.twodev.kotlinlearning.loadImage
import com.twodev.kotlinlearning.models.PlayerItems
import kotlinx.android.synthetic.main.item_video.view.*

class DetailVideoAdapter : RecyclerView.Adapter<DetailVideoAdapter.DetailVideoViewHolder>() {

    var list = mutableListOf<PlayerItems>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailVideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return DetailVideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailVideoViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItems(it: MutableList<PlayerItems>?) {
        it?.let { items -> list.addAll(items) }
        notifyDataSetChanged()
    }

    class DetailVideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(playerItems: PlayerItems) {
            imageView.loadImage(playerItems.player?.embedHtml.toString())
            itemTitle.text = playerItems.id
        }

        private val imageView: ImageView = itemView.findViewById(R.id.item_image_video)
        private val itemTitle: TextView = itemView.findViewById(R.id.item_title_video)
    }

}