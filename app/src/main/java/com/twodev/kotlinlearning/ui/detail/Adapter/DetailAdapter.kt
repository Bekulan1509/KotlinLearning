package com.twodev.kotlinlearning.ui.detail.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twodev.kotlinlearning.R
import com.twodev.kotlinlearning.loadImage
import com.twodev.kotlinlearning.models.DetailItems

class DetailAdapter(private var listener:(Int)->Unit) : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {
     var list = mutableListOf<DetailItems?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail, parent, false)
        return DetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        list[position]?.let { holder.onBind(it) }

        holder.itemView.setOnClickListener {
            listener(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItems(items: MutableList<DetailItems>?) {
        items?.let { list.addAll(it) }
        notifyDataSetChanged()
    }

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(detailItems: DetailItems) {

            detailItems?.snippet?.thumbnails?.medium?.url?.let { itemImage.loadImage(it) }
            itemTitle.text = detailItems?.snippet?.title
        }


        private val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        private val itemTitle: TextView = itemView.findViewById(R.id.item_title_video_textView)

    }


}



