package com.twodev.kotlinlearning.models

import androidx.room.PrimaryKey

data class PlayerModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var kind: String? = null,
    var etag: String? = null,
    var items: MutableList<PlayerItems>? = null,

    )

data class PlayerItems(
    var kind: String? = null,
    var etag: String? = null,
    var id: String? = null,
    var player: Player? = null,

)

data class Player(
    var embedHtml: String? = null
)
