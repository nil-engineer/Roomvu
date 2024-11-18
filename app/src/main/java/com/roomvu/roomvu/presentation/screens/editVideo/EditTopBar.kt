package com.roomvu.roomvu.presentation.screens.editVideo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roomvu.roomvu.R
import com.roomvu.roomvu.ui.theme.Blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTopBar(
//    videoState: VideoState,
    onCancelClicked: () -> Unit,
    onSaveClicked: (/*String, String*/) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val updateViewModel: EditVideoViewModel = hiltViewModel()
//    val onSaveClick: () -> Unit = {
////        Log.d("topbar", "EditTopBar: " + videoState.title!! + videoState.description!!)
////        onSaveClicked(
////            videoState.title, videoState.description
////        )
////        updateViewModel.updateVideo()
//        onSaveClicked()
//    }
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
//                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
            ) {
//
//                Text(
//                    text = "Cancel",
//                    color = Blue,
//                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight(400),
//                    textAlign = TextAlign.Start,
//                    modifier = Modifier.weight(1f)
//                )
                Text(
                    text = stringResource(R.string.cancel_btn_txt),
                    color = Blue,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(400),
                    modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = onCancelClicked),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = stringResource(R.string.edit_page_title),
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(590),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .weight(2f),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(R.string.save_btn),
                    color = Blue,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(400),
                    modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = onSaveClicked),
                    textAlign = TextAlign.End
                )
            }
        },
//        actions = {
//            IconButton(onClick = { expanded = !expanded }) {
//                Icon(
//                    imageVector = Icons.Default.MoreVert,
//                    contentDescription = "More",
//                )
//                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
//                    DropdownMenuItem(text = { Text("Edit") }, onClick = {
//                        expanded = false
//                    })
//                    DropdownMenuItem(text = { Text("Connect more social media") }, onClick = {
//                        expanded = false
//                    })
//                    DropdownMenuItem(text = { Text("Delete") }, onClick = {
//                        expanded = false
//                    })
//                }
//            }
//        }
    )
}

@Preview
@Composable
fun TopBarPreview() {
//    EditTopBar()
}