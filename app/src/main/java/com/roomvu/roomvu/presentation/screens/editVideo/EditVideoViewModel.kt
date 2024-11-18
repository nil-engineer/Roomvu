package com.roomvu.roomvu.presentation.screens.editVideo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roomvu.roomvu.domain.entities.VideoState
import com.roomvu.roomvu.domain.usecases.UpdateVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditVideoViewModel @Inject constructor(
//    private val savedStateHandle: SavedStateHandle,
    private val updateVideoUseCase: UpdateVideoUseCase): ViewModel(){

    var videoState by mutableStateOf(VideoState())
        private set

    init {
//        saveArguments()
    }
    fun updateVideo(/*title: String, desc: String*/){
        viewModelScope.launch {
            updateVideoUseCase.updateVideo(videoState.title!!, videoState.description!!)
        }
    }

    fun saveArguments(title: String, desc: String) {
        videoState =
            videoState.copy(
                title = title,
                description = desc,
            )
    }
}