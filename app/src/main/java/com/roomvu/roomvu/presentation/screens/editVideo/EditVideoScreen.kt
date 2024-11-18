package com.roomvu.roomvu.presentation.screens.editVideo

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.roomvu.roomvu.domain.entities.VideoState

@Composable
fun EditVideoScreen(
//    videoState: VideoState,
    onCancelClicked: () -> Unit,
    onSaveClicked: (/*String, String*/) -> Unit
) {

    var padding by remember { mutableStateOf(PaddingValues()) }

    Scaffold(
        topBar = { EditTopBar(/*videoState, */onCancelClicked, onSaveClicked) },
        content = {
            padding = it
            EditVideoContent(padding)
        }
    )
}

@Preview
@Composable
fun PreviewEdit() {
//    EditVideoScreen()
}

