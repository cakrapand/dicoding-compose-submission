package com.example.got.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object About : Screen("about")
    object Favorite : Screen("favorite")
    object Detail : Screen("home/{id}") {
        fun createRoute(id: Long) = "home/$id"
    }
}