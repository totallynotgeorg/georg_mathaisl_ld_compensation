package com.example.mybookshop.view.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.mybookshop.R
import com.example.mybookshop.model.Book

@Composable
fun BookRow(book: Book, modifier: Modifier, onItemClick: (String) -> Unit = {}){
    Card(modifier = modifier
        .clickable {
            onItemClick(book.isbn)
        }
        .fillMaxWidth()
        .padding(5.dp),
        shape = Shapes().large,
        elevation = 10.dp
    ) {
        Column {
            Box(modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                BookImage(imageUrl = book.coverImage)
            }

            MovieDetails(modifier = Modifier.padding(12.dp), book = book)
        }
    }
}

@Composable
fun BookImage(imageUrl: String) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(id = R.string.book_cover),
        loading = {
            CircularProgressIndicator()
        }
    )
}

@Composable
fun MovieDetails(modifier: Modifier = Modifier, book: Book) {

    var expanded = false

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            book.title,
            modifier = Modifier.weight(6f),
            style = MaterialTheme.typography.headlineSmall
        )

        IconButton(
            modifier = Modifier.weight(1f),
            onClick = { expanded = !expanded }) {
            Icon(imageVector =
            if (expanded) Icons.Filled.KeyboardArrowDown
            else Icons.Filled.KeyboardArrowUp,
                contentDescription = "expand",
                modifier = Modifier
                    .size(25.dp),
                tint = Color.DarkGray
            )
        }
    }

    AnimatedVisibility(
        visible = expanded,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Column (modifier = modifier) {
            Text(text = "ISBN: ${book.isbn}", style = MaterialTheme.typography.titleSmall)
            Text(text = "Title: ${book.isbn}", style = MaterialTheme.typography.titleSmall)
            Text(text = "Author: ${book.isbn}", style = MaterialTheme.typography.titleSmall)
            Text(text = "Publishing Year: ${book.isbn}", style = MaterialTheme.typography.titleSmall)
        }
    }
}
