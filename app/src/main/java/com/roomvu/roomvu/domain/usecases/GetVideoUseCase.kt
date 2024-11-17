package com.roomvu.roomvu.domain.usecases

import com.roomvu.roomvu.domain.entities.networkEntities.VideoEntity
import com.roomvu.roomvu.domain.repo.VideoRepository
import com.roomvu.roomvu.util.Resource
import javax.inject.Inject

class GetVideoUseCase @Inject constructor(private val videoRepository: VideoRepository){
    suspend fun getVideo(): VideoEntity{
        return videoRepository.getVideo()
    }
}