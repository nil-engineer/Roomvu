package com.roomvu.roomvu.navigation

sealed class Screen(val route: String) {
    object Main : Screen(route = "main_screen")
    object Edit: Screen(route = "edit_screen")

}