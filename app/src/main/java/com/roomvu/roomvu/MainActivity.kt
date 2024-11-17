package com.roomvu.roomvu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.roomvu.roomvu.presentation.screens.videoContent.MainTopBar
import com.roomvu.roomvu.presentation.screens.videoContent.VideoContent
import com.roomvu.roomvu.ui.theme.RoomvuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomvuTheme {
                VideoScreen()
            }
        }
    }
}


@Composable
fun VideoScreen() {
    var padding by remember { mutableStateOf(PaddingValues()) }

    Scaffold(
        topBar = { MainTopBar() },
        content = {
            padding = it
            VideoContent(padding)
        }
    )
}


@Preview(showBackground = true)
@Composable
fun VideoPreview() {
    VideoScreen()
}