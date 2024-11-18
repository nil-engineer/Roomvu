package com.roomvu.roomvu.presentation.screens.videoContent

import android.content.Context
import android.net.Uri
import androidx.annotation.OptIn
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MimeTypes
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.DefaultRenderersFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlayerViewModel : ViewModel() {

    private val _playerState = MutableStateFlow<ExoPlayer?>(null)
    val playerState: StateFlow<ExoPlayer?> = _playerState

    private var currentPosition: Long = 0L

    @OptIn(UnstableApi::class)
    fun initializePlayer(context: Context, videoUrl: String) {
        if (_playerState.value == null) {
            viewModelScope.launch {
                val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()

                val exoPlayer = ExoPlayer.Builder(context).setRenderersFactory(
                    DefaultRenderersFactory(context).setEnableDecoderFallback(true)
                ).build()
                val mediaItem = MediaItem.Builder()
                    .setUri(Uri.parse(videoUrl))
                    .setMimeType(MimeTypes.APPLICATION_MP4)
                    .build()
                val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(mediaItem)
//                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.setMediaSource(mediaSource)
                exoPlayer.prepare()
                exoPlayer.play()

//                    val mediaItem = MediaItem.fromUri(Uri.parse(videoUrl))
//                    val mediaItem = MediaItem.Builder().setUri((Uri.parse(videoUrl)).setMimeType()
//                    val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
//                    val mediaSource = ProgressiveMediaSource.Factory(defaultHttpDataSourceFactory)
//                        .createMediaSource(mediaItem).
//                    it.setMediaSource(mediaSource)
//                    it.setMediaItem(mediaItem)
//                    it.prepare()
//                    it.playWhenReady = true
//                    it.seekTo(currentPosition)
//                    it.addListener(object : Player.Listener {
//                        override fun onPlayerError(error: PlaybackException) {
//                            handleError(error)
//                        }
//                    })
//                    delay(5000)

                _playerState.value = exoPlayer
            }
        }
    }

    fun savePlayerState() {
        _playerState.value?.let {
            currentPosition = it.currentPosition
        }
    }

    fun releasePlayer() {
        _playerState.value?.release()
        _playerState.value = null
    }

    private fun handleError(error: PlaybackException) {
        when (error.errorCode) {
            PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED -> {
                // Handle network connection error
                println("Network connection error")
            }

            PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND -> {
                // Handle file not found error
                println("File not found")
            }

            PlaybackException.ERROR_CODE_DECODER_INIT_FAILED -> {
                // Handle decoder initialization error
                println("Decoder initialization error")
            }

            else -> {
                // Handle other types of errors
                println("Other error: ${error.message}")
            }
        }
    }
}