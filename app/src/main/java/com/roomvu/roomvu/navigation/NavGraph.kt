package com.roomvu.roomvu.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roomvu.roomvu.VideoScreen
import com.roomvu.roomvu.presentation.screens.editVideo.EditVideoScreen
import com.roomvu.roomvu.presentation.screens.editVideo.EditVideoViewModel

@Composable
fun SetupNavGraph(
    startDestination: String, navController: NavHostController,
) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        mainRoute(navigateToEditScreen = {
            navController.navigate(Screen.Edit.route)
        })
        editVideoRoute(
            onCancelClicked = {
                navController.popBackStack()
            },
            navigateToMainScreen = {
                navController.popBackStack()
            }
        )
    }
}

fun NavGraphBuilder.mainRoute(navigateToEditScreen: () -> Unit) {
    composable(Screen.Main.route) {
        VideoScreen(navigateToEditScreen)
    }
}

fun NavGraphBuilder.editVideoRoute(
    onCancelClicked: () -> Unit,
    navigateToMainScreen: () -> Unit,
//    onSaveClicked: (/*String, String*/) -> Unit
) {
    composable(Screen.Edit.route) {
        val viewModel: EditVideoViewModel = hiltViewModel()
        val updateState = viewModel.updateStatus.collectAsState().value
        val context = LocalContext.current
        EditVideoScreen(
//            videoState,
            onCancelClicked,
            onSaveClicked = { /*title, desc ->*/
//                Log.d("edit video", "editVideoRoute: " + title + desc)
                viewModel.updateVideo()
                if(updateState == "success"){
                    Toast.makeText(context, "Video data updated successfully!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, "Update failed!", Toast.LENGTH_SHORT).show()
                }
                navigateToMainScreen()
//                viewModel.saveArguments(title, desc)
//                onCancelClicked()
            })
    }
}