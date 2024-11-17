package com.roomvu.roomvu.presentation.screens.videoContent

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {
    private val _openDialog = MutableStateFlow(false)
    val openDialog = _openDialog.asStateFlow()

    fun updateDialogState(state: Boolean){
        _openDialog.value = state
    }
}