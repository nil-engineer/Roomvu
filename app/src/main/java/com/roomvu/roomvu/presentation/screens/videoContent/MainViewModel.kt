package com.roomvu.roomvu.presentation.screens.videoContent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roomvu.roomvu.domain.entities.networkEntities.VideoEntity
import com.roomvu.roomvu.domain.usecases.GetVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getVideoUseCase: GetVideoUseCase) :
    ViewModel() {
    private val _openDialog = MutableStateFlow(false)
    val openDialog = _openDialog.asStateFlow()

    private val _video = MutableLiveData<VideoEntity>()
    var video: LiveData<VideoEntity> = _video
    var time = ""
    fun updateDialogState(state: Boolean) {
        _openDialog.value = state
    }

    fun fetchVideo() {
        viewModelScope.launch {
            val vid = getVideoUseCase.getVideo()
            _video.value = vid
        }
    }

    fun getTimePart(): String {
        viewModelScope.launch {
//            if(video != null) {
            time = video.value?.data?.video?.publishAt?.split(" ")?.get(1) ?: ""
//            }
        }
        return time
    }
}