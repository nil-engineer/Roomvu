package com.roomvu.roomvu.presentation.screens.components

import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.roomvu.roomvu.R

@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(player: ExoPlayer?) {
    var lifecycle by remember {
        mutableStateOf(Lifecycle.Event.ON_CREATE)
    }
    AndroidView(
        modifier = Modifier
            .height(dimensionResource(id = R.dimen.player_height).value.dp)
            .fillMaxWidth(),
        factory = { context ->
            PlayerView(context).apply {
                this.player = player
            }
        },
        update = { playerView ->
            playerView.player = player
            when (lifecycle) {
                Lifecycle.Event.ON_PAUSE -> {
                    playerView.onPause()
                    playerView.player?.pause()
                    player?.playWhenReady = false
                }
                Lifecycle.Event.ON_RESUME -> {
                    playerView.onResume()
                    player?.playWhenReady = false

                }
                else -> Unit
            }
        }
    )
}