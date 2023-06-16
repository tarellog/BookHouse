package com.example.bookhouse.ui

import com.example.bookhouse.data.model.Books

sealed class BooksUiState {

    data class Success(val dataBooks: List<Books>) : BooksUiState()
    object Loading : BooksUiState()
    object Error : BooksUiState()

}
