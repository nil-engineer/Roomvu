package com.roomvu.roomvu.domain.repo

import com.roomvu.roomvu.domain.entities.networkEntities.VideoEntity
import com.roomvu.roomvu.util.Resource

interface VideoRepository {
    suspend fun getVideo(): VideoEntity
}