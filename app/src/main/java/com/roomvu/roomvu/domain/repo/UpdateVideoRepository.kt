package com.roomvu.roomvu.domain.repo

interface UpdateVideoRepository {
    suspend fun updateVideo(title: String, description: String)
}