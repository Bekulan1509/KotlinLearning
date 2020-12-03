package com.twodev.kotlinlearning.models

data class PlayListDetail(
    var kind: String? = null,
    var etag: String? = null,
    var nextPageToken: String? = null,
    var items: MutableList<DetailItems>? = null,
)

data class DetailItems(
    var kind: String? = null,
    var etag: String? = null,
    var id: String? = null,
    var snippet: SnippetDetail? = null
)

data class SnippetDetail(
    var channelId: String? = null,
    var title: String? = null,
    var description: String? = null,
    var position: String? = null,
    var thumbnails: ThumbnailsDetail? = null,
  //  var resourceId: ResourceId? = null
)

//data class ResourceId

data class ThumbnailsDetail(
    var medium: MediumDetails? = null
)

data class MediumDetails(
    var url: String? = null
)


