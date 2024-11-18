package com.roomvu.roomvu.presentation.screens.videoContent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.roomvu.roomvu.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(navigateToEditScreen: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var openAlertDialog by remember { mutableStateOf(false) }
    val mainViewModel: MainViewModel = hiltViewModel()
    val dialogState = mainViewModel.openDialog.collectAsState().value

    val onDeleteClicked: () -> Unit = {
        mainViewModel.updateDialogState(true)
    }

    if(dialogState){
        DeleteConfirmAlert()
    }
    TopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Video",
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(590),
                modifier = Modifier.align(Alignment.CenterVertically),
                textAlign = TextAlign.Center
            )
        }
    },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                )
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    DropdownMenuItem(text = { Text(stringResource(R.string.edit_menu_name)) }, onClick = {
                        expanded = false
                        navigateToEditScreen()
                    })
                    DropdownMenuItem(text = { Text(stringResource(R.string.social_media_menu_name)) }, onClick = {
                        expanded = false
                    })
                    DropdownMenuItem(text = { Text(stringResource(R.string.delete_menu_name)) }, onClick = {
                        expanded = false
                        onDeleteClicked()
                    })
                }
            }
        })
}

@Composable
fun DeleteConfirmAlert() {
    val openDialog = remember { mutableStateOf(false)  }
    val mainViewModel: MainViewModel = hiltViewModel()
//    val dialogState = mainViewModel.openDialog.value
    AlertDialog(
        containerColor = AlertDialogDefaults.containerColor,
        onDismissRequest = {
//            openDialog.value = false
            mainViewModel.updateDialogState(false)
        },
        title = {
            Text(text = stringResource(R.string.delete_post_dialog_title),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(590),
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        },
        text = {
            Text(
                stringResource(R.string.delete_dialog_text),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(400),
                textAlign = TextAlign.Center,
                color = Color.Black)
        },
        confirmButton = {
            TextButton(
                onClick = {
//                    openDialog.value = false
                    mainViewModel.updateDialogState(false)

                }) {
                Text(
                    stringResource(R.string.delete_btn),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(400),
                    color = Color.Black)
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
//                    openDialog.value = false
                    mainViewModel.updateDialogState(false)

                }) {
                Text(
                    stringResource(R.string.cancel_btn),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(400),
                    color = Color.Black)
            }
        }
    )
}

@Preview
@Composable
fun PreviewAlert() {
//    DeleteConfirmAlert()
}