package com.roomvu.roomvu.presentation.screens.editVideo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roomvu.roomvu.domain.entities.VideoState
import com.roomvu.roomvu.domain.usecases.UpdateVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditVideoViewModel @Inject constructor(
    private val updateVideoUseCase: UpdateVideoUseCase): ViewModel(){

    var videoState by mutableStateOf(VideoState())
        private set
    private val _updateStatus = MutableStateFlow("success")
    val updateStatus = _updateStatus.asStateFlow()

    fun updateVideo(){
        viewModelScope.launch {
            updateVideoUseCase.updateVideo(videoState.title!!, videoState.description!!)
            _updateStatus.value = updateVideoUseCase.updateVideo(videoState.title!!, videoState.description!!).status
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