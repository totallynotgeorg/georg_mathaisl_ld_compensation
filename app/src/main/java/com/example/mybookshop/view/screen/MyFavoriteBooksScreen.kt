package com.example.mybookshop.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.labyrinthpuzzle.view.widgets.HomeTopAppBar
import com.example.mybookshop.view.widgets.BookRow
import com.example.mybookshop.viewModels.BookVm

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyFavoriteBooksScreen(navController: NavController = rememberNavController(), bookVm: BookVm) {
    Scaffold(topBar = {
        HomeTopAppBar(title = "My favorite books",
            menuContent = {
                androidx.compose.material.DropdownMenuItem(onClick = {navController.navigate(Screen.CreateBookScreen.route)}) {
                    Row {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Add Book", modifier = Modifier.padding(4.dp))
                        Text(text = "Add Book", modifier = Modifier
                            .width(100.dp)
                            .padding(4.dp))
                    }
                }
            })
    }) { padding ->
        MainContent(
            modifier = Modifier.padding(padding),
            navController = navController,
            bookVm = bookVm
        )
    }
}

@Composable
fun MainContent(modifier: Modifier, navController: NavController, bookVm: BookVm) {
    BookList(modifier = modifier, navController = navController, bookVm = bookVm)
}

@Composable
fun BookList(modifier: Modifier, navController: NavController, bookVm: BookVm){
    LazyColumn(modifier = modifier, contentPadding = PaddingValues(all = 12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)){
        items(bookVm.bookList){ book ->
            BookRow(book = book, modifier = modifier)
        }
    }
}