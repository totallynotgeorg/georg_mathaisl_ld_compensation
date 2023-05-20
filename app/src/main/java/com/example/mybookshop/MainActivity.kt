package com.example.mybookshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.mybookshop.ui.theme.MybookshopTheme
import com.example.mybookshop.view.navigation.Navigation
import com.example.mybookshop.viewModels.BookVm

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bookVm: BookVm by viewModels()
        setContent {
            MybookshopTheme {
                Navigation(bookVm)
            }
        }
    }
}