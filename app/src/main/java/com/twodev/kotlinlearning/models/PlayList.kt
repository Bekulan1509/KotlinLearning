package com.twodev.kotlinlearning.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.twodev.kotlinlearning.models.converter.PlayListItemsConverter

@Entity(tableName = "playList")
data class PlayList(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var kind: String? = null,
    var etag: String? = null,
    var items: MutableList<PlayListItems>? = null,

    )

data class PlayListItems(
    var kind: String? = null,
    var etag: String? = null,
    var id: String? = null,
    var snippet: Snippet? = null,
    var contentDetails:ContentDetails?=null
)

data class Snippet(
    var publishedAt: String? = null,
    var channelId: String? = null,
    var title: String? = null,
    var description: String? = null,
    var thumbnails: Thumbnails? = null,
)

data class Thumbnails(
    var medium: Medium? = null
)

data class Medium(
    var url: String? = null
)
data class ContentDetails(
    var  itemCount:String?=null
)