package com.example.mybookshop.view.screen

sealed class Screen (val route: String) {
    object MyFavortieBooksScreen : Screen("home")
    object CreateBookScreen : Screen("create")
}