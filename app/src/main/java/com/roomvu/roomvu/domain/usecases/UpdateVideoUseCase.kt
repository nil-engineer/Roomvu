package com.roomvu.roomvu.domain.usecases

import com.roomvu.roomvu.data.repository.UpdateVideoRepositoryImpl
import com.roomvu.roomvu.domain.entities.networkEntities.UpdateVideoResponse
import javax.inject.Inject

class UpdateVideoUseCase @Inject constructor(private val updateVideoRepositoryImpl: UpdateVideoRepositoryImpl) {
    suspend fun updateVideo(title: String, description: String): UpdateVideoResponse {
        return updateVideoRepositoryImpl.updateVideo(title, description)
    }
}