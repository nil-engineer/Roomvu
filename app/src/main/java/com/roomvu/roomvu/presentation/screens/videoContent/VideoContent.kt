package com.roomvu.roomvu.presentation.screens.videoContent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.roomvu.roomvu.R
import com.roomvu.roomvu.presentation.screens.components.VideoPlayer
import com.roomvu.roomvu.ui.theme.BgGray
import com.roomvu.roomvu.ui.theme.BodyTextColor
import com.roomvu.roomvu.ui.theme.BorderGray
import com.roomvu.roomvu.ui.theme.Purple
import com.roomvu.roomvu.ui.theme.secondaryTextColor

@Composable
fun VideoContent(paddingValues: PaddingValues) {
    val interactionSource = remember { MutableInteractionSource() }
    val mainViewModel: MainViewModel = hiltViewModel()
    mainViewModel.fetchVideo()
    val video = mainViewModel.video.observeAsState().value
    val playerViewModel = PlayerViewModel()
    val player by playerViewModel.playerState.collectAsState()
    val context = LocalContext.current

    if (video != null) {
        LaunchedEffect(video.data.video.videoUrl) {
            playerViewModel.initializePlayer(context, video.data.video.videoUrl)
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            playerViewModel.savePlayerState()
            playerViewModel.releasePlayer()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgGray)
            .navigationBarsPadding()
            .padding(top = paddingValues.calculateTopPadding())
            .padding(15.dp)
    ) {
        Text(
            text = "Jan 21",
            color = BodyTextColor,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight(590)
        )
//        Box(contentAlignment = Alignment.Center) {
//        if (video != null) {
//            AsyncImage(
//                modifier = Modifier.fillMaxWidth(),
//                model = video.data.video.thumbnail,
//                contentDescription = "thumb",
//                contentScale = ContentScale.Fit
//            )
//        }
//        Button(onClick = {},
//            shape = CircleShape,
//            modifier = Modifier.size(70.dp)) {
//            Image(painter = painterResource(R.drawable.ic_play),
//                contentDescription = "play")
//        }
        VideoPlayer(player)
//    }



        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_video),
                contentDescription = "video"
            )
            if (video != null) {
                Text(
                    text = video.data.video.title,
                    color = BodyTextColor,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(590),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 5.dp),
                    maxLines = 3
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.ic_time),
                contentDescription = "video"
            )
            Text(
                text = mainViewModel.getTimePart(),
                color = BodyTextColor,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(590),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 3.dp)
            )
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Purple),
                shape = RoundedCornerShape(30.dp),
                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
                modifier = Modifier
                    .defaultMinSize(
                        minWidth = ButtonDefaults.MinWidth,
                        minHeight = 10.dp
                    )
                    .padding(start = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_magic_wand),
                    contentDescription = "video",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "A.I. Picked",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(590),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "This video will be posted on",
                color = BodyTextColor,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(590),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(end = 15.dp)
            )
            if (video != null) {
                if (video.data.video.platforms.linkedin) {
                    Image(
                        painter = painterResource(R.drawable.ic_linkedin),
                        contentDescription = "linkedin"
                    )
                }
                if (video.data.video.platforms.twitter) {
                    Image(
                        painter = painterResource(R.drawable.ic_twitter),
                        contentDescription = "linkedin"
                    )
                }
                if (video.data.video.platforms.instagram) {
                    Image(
                        painter = painterResource(R.drawable.ic_instagram),
                        contentDescription = "linkedin"
                    )
                }
            }

        }
        Card(
            modifier = Modifier
                // The space between each card and the other
                .padding(bottom = 10.dp, top = 25.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                if (video != null) {
                    Text(
                        text = video.data.video.title,
                        color = BodyTextColor,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(590)
                    )
                }
                if (video != null) {
                    Text(
                        text = video.data.video.description,
                        color = BodyTextColor,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(400),
                        modifier = Modifier.padding(top = 10.dp),
                        maxLines = 10
                    )
                }
            }
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = MaterialTheme.shapes.small,
            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(
                    minWidth = ButtonDefaults.MinWidth,
//                    minHeight = 10.dp
                ),
            border = BorderStroke(1.dp, BorderGray)
        ) {

            Image(
                painter = painterResource(R.drawable.ic_cam),
                contentDescription = "cam",
                modifier = Modifier.padding(end = 15.dp)
            )
            Text(
                text = "Record personal intro",
                color = secondaryTextColor,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(600)
            )

        }
    }
}