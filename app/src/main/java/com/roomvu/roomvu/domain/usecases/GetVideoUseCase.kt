package com.roomvu.roomvu.domain.usecases

import com.roomvu.roomvu.domain.entities.networkEntities.VideoResponse
import com.roomvu.roomvu.domain.repo.VideoRepository
import javax.inject.Inject

class GetVideoUseCase @Inject constructor(private val videoRepository: VideoRepository){
    suspend fun getVideo(): VideoResponse{
        return videoRepository.getVideo()
    }
}