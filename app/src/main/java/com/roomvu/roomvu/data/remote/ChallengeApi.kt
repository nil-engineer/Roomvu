package com.roomvu.roomvu.data.remote

import com.roomvu.roomvu.domain.entities.networkEntities.VideoEntity
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PUT

interface ChallengeApi {
    @GET("v1/dev/android-challenge/video")
    suspend fun getVideo(): VideoEntity

    @FormUrlEncoded
    @PUT("v1/dev/android-challenge/video")
    suspend fun updateVideo(
        @Field("title") title: String,
        @Field("description") description: String
    )
}