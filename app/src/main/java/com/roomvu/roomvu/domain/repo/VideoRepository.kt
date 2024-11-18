package com.roomvu.roomvu.domain.repo

import com.roomvu.roomvu.domain.entities.networkEntities.VideoResponse

interface VideoRepository {
    suspend fun getVideo(): VideoResponse
}