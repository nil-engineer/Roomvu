package com.roomvu.roomvu.domain.entities.networkEntities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UpdateVideoResponse(
    @Json(name = "data")
    val data: List<Any>,
    @Json(name = "message")
    val message: String?,
    @Json(name = "status")
    val status: String
)