package com.example.bookhouse.ui.booksscreen.booksitem

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookhouse.SampleData.listData
import com.example.bookhouse.data.model.Books

@Composable
fun BooksGrid(
    books: List<Books>,
    onBookClicked: (Books) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        itemsIndexed(books) { _, dataBooks ->
            BooksItem(books = dataBooks, onBookClicked)
        }
    }
}

@Preview
@Composable
fun BooksGridPreview() {
    BooksGrid(
        books = listData,
        onBookClicked = { listData }
    )
}