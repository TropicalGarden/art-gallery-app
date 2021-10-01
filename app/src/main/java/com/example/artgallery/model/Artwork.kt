package com.example.artgallery.model

import com.squareup.moshi.Json

data class Art(
    @Json(name = "results") var artworks: List<Artwork>
)

data class Artwork(
    @Json(name = "deviationid") var artworkId: String,
    var content: Content
)

data class Content(
    @Json(name = "src") var imageSource: String
)
