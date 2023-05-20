package com.example.mybookshop.view.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.labyrinthpuzzle.view.widgets.SimpleTopAppBar
import com.example.mybookshop.R
import com.example.mybookshop.model.Book
import com.example.mybookshop.viewModels.BookVm

@Composable
fun CreateBookScreen(navController: NavController = rememberNavController(), bookVm: BookVm) {
    val scaffoldState = rememberScaffoldState()

    androidx.compose.material.Scaffold(scaffoldState = scaffoldState, topBar = {
        SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
            Text(text = stringResource(id = R.string.add_book))
        }
    }) { padding ->
        MainContent(modifier = Modifier.padding(padding), bookVm = bookVm)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(modifier: Modifier, bookVm: BookVm) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            var isbn by remember {
                mutableStateOf("")
            }

            var title by remember {
                mutableStateOf("")
            }

            var publishYear by remember {
                mutableStateOf("")
            }

            var author by remember {
                mutableStateOf("")
            }

            androidx.compose.material.OutlinedTextField(value = isbn,
                onValueChange = {
                    isbn = it
                    bookVm.validateIsbn(isbn)
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = { Text(text = stringResource(id = R.string.enter_isbn)) },
                isError = bookVm.isbnError.value!!
            )

            androidx.compose.material.OutlinedTextField(value = title,
                onValueChange = {
                    title = it
                    bookVm.validateTitle(title)
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = { Text(text = stringResource(id = R.string.enter_title)) },
                isError = bookVm.titleError.value!!
            )

            androidx.compose.material.OutlinedTextField(value = author,
                onValueChange = {
                    author = it
                    bookVm.validateAuthor(author)
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = { Text(text = stringResource(id = R.string.enter_title)) },
                isError = bookVm.authorError.value!!
            )

            OutlinedTextField(
                value = publishYear,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    publishYear = it
                    bookVm.validateYear(publishYear)
                },
                label = { Text(stringResource(R.string.enter_book_year)) },
                isError = bookVm.publishYearError.value!!,
            )

            Button(
                enabled = bookVm.isAddButtonEnabled.value as Boolean,
                onClick = {
                    val book = Book(
                        isbn = isbn,
                        title = title,
                        author = author,
                        publishYear = publishYear,
                        coverImage = "https://images-na.ssl-images-amazon.com/images/M/MV5BNzM2MDk3MTcyMV5BMl5BanBnXkFtZTcwNjg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg"
                    )
                    bookVm.createBook(book)
                }) {
                Text(text = stringResource(R.string.add))
            }
        }
    }
}