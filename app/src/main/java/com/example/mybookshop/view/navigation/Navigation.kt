package com.example.mybookshop.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybookshop.view.screen.CreateBookScreen
import com.example.mybookshop.view.screen.MyFavoriteBooksScreen
import com.example.mybookshop.view.screen.Screen
import com.example.mybookshop.viewModels.BookVm

@Composable
fun Navigation(bookVm: BookVm){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MyFavortieBooksScreen.route){
        composable(route = Screen.MyFavortieBooksScreen.route){
            MyFavoriteBooksScreen(navController = navController, bookVm = bookVm)
        }

        composable(route = Screen.CreateBookScreen.route){
            CreateBookScreen(navController = navController, bookVm = bookVm)
        }
    }
}