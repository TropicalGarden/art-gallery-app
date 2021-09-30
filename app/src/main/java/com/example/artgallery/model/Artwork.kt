package com.example.artgallery.model

import com.squareup.moshi.Json

data class Art(
    @Json(name = "results") val artworks: List<Artwork>
)

data class Artwork(
    @Json(name = "deviationid") val artworkId: String,
    val content: Content
)

data class Content(
    @Json(name = "src") val imageSource: String
)
