package com.roomvu.roomvu.presentation.screens.videoContent

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roomvu.roomvu.connectivity.ConnectivityObserver
import com.roomvu.roomvu.connectivity.NetworkConnectivityObserver
import com.roomvu.roomvu.domain.entities.networkEntities.VideoResponse
import com.roomvu.roomvu.domain.usecases.GetVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val connectivity: NetworkConnectivityObserver,
    private val getVideoUseCase: GetVideoUseCase
) :
    ViewModel() {
    private val _openDialog = MutableStateFlow(false)
    val openDialog = _openDialog.asStateFlow()
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _video = MutableLiveData<VideoResponse>()
    var video: LiveData<VideoResponse> = _video
    private var time = ""
    private var network by mutableStateOf(ConnectivityObserver.Status.Available)

    init {
        fetchVideo()
        viewModelScope.launch {
            connectivity.observe().collect {
                network = it
            }
        }
    }

    fun updateDialogState(state: Boolean) {
        _openDialog.value = state
    }

    private fun fetchVideo() {
        if (network == ConnectivityObserver.Status.Available) {
            viewModelScope.launch {
                val vid = getVideoUseCase.getVideo()
                _video.value = vid
            }
            _isLoading.value = false
        }
        else {
            _isLoading.value = true
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