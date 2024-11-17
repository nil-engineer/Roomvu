package com.roomvu.roomvu.presentation.screens.videoContent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar() {
    var expanded by remember { mutableStateOf(false) }

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
                    DropdownMenuItem(text = { Text("Edit") }, onClick = {
                        expanded = false
                    })
                    DropdownMenuItem(text = { Text("Connect more social media") }, onClick = {
                        expanded = false
                    })
                    DropdownMenuItem(text = { Text("Delete") }, onClick = {
                        expanded = false
                    })
                }
            }
        })
}