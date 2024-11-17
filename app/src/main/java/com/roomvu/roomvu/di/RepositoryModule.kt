package com.roomvu.roomvu.di

import com.roomvu.roomvu.data.repository.VideoRepositoryImpl
import com.roomvu.roomvu.domain.repo.VideoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindVideoRepository(videoRepositoryImpl: VideoRepositoryImpl): VideoRepository

//    @Binds
//    @Singleton
//    abstract fun bindUpdateVideoRepository(updateVideoRepositoryImpl: UpdateVideoRepositoryImpl): UpdateVideoRepositoryImpl
}