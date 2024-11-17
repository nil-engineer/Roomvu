package com.roomvu.roomvu.domain.usecases

import com.roomvu.roomvu.data.repository.UpdateVideoRepositoryImpl
import com.roomvu.roomvu.domain.repo.VideoRepository
import javax.inject.Inject

class UpdateVideoUseCase @Inject constructor(private val videoRepositoryImpl: UpdateVideoRepositoryImpl) {
    suspend fun updateVideo(title: String, description: String){
        videoRepositoryImpl.updateVideo(title, description)
    }
}