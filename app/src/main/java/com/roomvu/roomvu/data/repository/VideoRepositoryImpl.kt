package com.roomvu.roomvu.data.repository

import com.roomvu.roomvu.data.remote.ChallengeApi
import com.roomvu.roomvu.domain.entities.networkEntities.VideoEntity
import com.roomvu.roomvu.domain.repo.VideoRepository
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(private val api: ChallengeApi): VideoRepository{
    override suspend fun getVideo(): VideoEntity {
        return api.getVideo()
    }
}