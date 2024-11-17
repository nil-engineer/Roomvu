package com.roomvu.roomvu.domain.entities.networkEntities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideoEntity(
    @Json(name = "data")
    val data: Data,
    @Json(name = "message")
    val message: String?,
    @Json(name = "status")
    val status: String
)

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "video")
    val video: Video
)

@JsonClass(generateAdapter = true)
data class Video(
    @Json(name = "description")
    val description: String,
    @Json(name = "platforms")
    val platforms: Platforms,
    @Json(name = "publish_at")
    val publishAt: String,
    @Json(name = "thumbnail")
    val thumbnail: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "video_url")
    val videoUrl: String
)

@JsonClass(generateAdapter = true)
data class Platforms(
    @Json(name = "instagram")
    val instagram: Boolean,
    @Json(name = "linkedin")
    val linkedin: Boolean,
    @Json(name = "twitter")
    val twitter: Boolean
)


