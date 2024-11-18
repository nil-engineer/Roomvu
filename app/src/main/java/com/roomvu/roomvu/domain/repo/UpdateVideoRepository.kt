package com.roomvu.roomvu.domain.repo

import com.roomvu.roomvu.domain.entities.networkEntities.UpdateVideoResponse

interface UpdateVideoRepository {
    suspend fun updateVideo(title: String, description: String): UpdateVideoResponse
}