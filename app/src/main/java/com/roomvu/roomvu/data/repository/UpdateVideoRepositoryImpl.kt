package com.roomvu.roomvu.data.repository

import com.roomvu.roomvu.data.remote.ChallengeApi
import com.roomvu.roomvu.domain.entities.networkEntities.UpdateVideoResponse
import com.roomvu.roomvu.domain.repo.UpdateVideoRepository
import javax.inject.Inject

class UpdateVideoRepositoryImpl @Inject constructor(private val api: ChallengeApi): UpdateVideoRepository {
    override suspend fun updateVideo(title: String, description: String): UpdateVideoResponse {
        return api.updateVideo(title, description)
    }

}