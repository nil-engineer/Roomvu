package com.roomvu.roomvu.data.repository

import com.roomvu.roomvu.data.remote.ChallengeApi
import com.roomvu.roomvu.domain.repo.UpdateVideoRepository
import javax.inject.Inject

class UpdateVideoRepositoryImpl @Inject constructor(private val api: ChallengeApi): UpdateVideoRepository {
    override suspend fun updateVideo(title: String, description: String) {
        api.updateVideo(title, description)
    }


}