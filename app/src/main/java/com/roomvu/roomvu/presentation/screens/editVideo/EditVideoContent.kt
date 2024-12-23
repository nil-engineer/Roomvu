package com.roomvu.roomvu.presentation.screens.editVideo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.roomvu.roomvu.R
import com.roomvu.roomvu.ui.theme.BgGray
import com.roomvu.roomvu.ui.theme.Blue
import com.roomvu.roomvu.ui.theme.BodyTextColor
import com.roomvu.roomvu.ui.theme.Gray

@Composable
fun EditVideoContent(paddingValues: PaddingValues){
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    val updateViewModel: EditVideoViewModel = hiltViewModel()
    updateViewModel.saveArguments(title, content)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgGray)
            .navigationBarsPadding()
            .padding(top = paddingValues.calculateTopPadding())
            .padding(dimensionResource(id = R.dimen.content_padding).value.dp)
    ) {

        OutlinedTextField(
            shape = MaterialTheme.shapes.medium,
            value = title,
            onValueChange = { title = it },
            textStyle = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(590),
                color = BodyTextColor,
                fontSize = dimensionResource(id = R.dimen.main_txt_size).value.sp,
                ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Blue,
                unfocusedLabelColor = Gray,
                unfocusedPlaceholderColor = Gray,
                focusedLabelColor = BodyTextColor,
                focusedPlaceholderColor = BodyTextColor,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Blue,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            label = {
                Text(
                    stringResource(R.string.edit_title_label),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(400),
                    color = Gray
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.title_placeholder),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(590)
                )
            },
            supportingText = {},
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            shape = MaterialTheme.shapes.medium,
            value = content,
            onValueChange = { content = it },
            textStyle = TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(400),
                color = BodyTextColor,
                fontSize = dimensionResource(id = R.dimen.main_txt_size).value.sp,

                ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Blue,
                unfocusedLabelColor = Gray,
                unfocusedPlaceholderColor = Gray,
                focusedLabelColor = BodyTextColor,
                focusedPlaceholderColor = BodyTextColor,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Blue,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            label = {
                Text(
                    stringResource(R.string.edit_content_label),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(400),
                    color = Gray
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.edit_content_placeholder),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(590)
                )
            },
            supportingText = {},
            maxLines = 10,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PreviewEditContent(){
//    EditVideoScreen()
}