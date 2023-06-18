package com.example.bookhouse.ui.booksscreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookhouse.ui.BooksUiState
import com.example.bookhouse.ui.booksscreen.booksitem.BooksGrid
import com.example.bookhouse.ui.booksscreen.errorscreen.ErrorScreen
import com.example.bookhouse.ui.booksscreen.loadingscreen.LoadingScreen

@Composable
fun BooksStateScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (booksUiState) {
        is BooksUiState.Loading -> LoadingScreen()
        is BooksUiState.Success -> BooksGrid(books = booksUiState.dataBooks)
        is BooksUiState.Error -> ErrorScreen(retryAction = retryAction)
    }
}