package com.example.bookhouse.ui.booksscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookhouse.data.model.Books
import com.example.bookhouse.ui.BooksViewModel
import com.example.bookhouse.ui.booksscreen.searchtoolbar.SearchToolbarState
import com.example.bookhouse.ui.booksscreen.searchtoolbar.ToolbarState

@Composable
fun BooksScreen(
    modifier: Modifier = Modifier,
    onBookClicked: (Books) -> Unit
) {
    val viewModel: BooksViewModel = viewModel(factory = BooksViewModel.Factory)
    val uiState by viewModel.booksUiState.collectAsState()
    val searchToolbarState by viewModel.searchToolbarState.collectAsState()
    val searchText by viewModel.searchText.collectAsState()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ToolbarState(
                searchToolbarState = searchToolbarState,
                searchText = searchText,
                onTextChange = { viewModel.updateSearchText(query = it) },
                onCloseClicked = { viewModel.updateSearchState(SearchToolbarState.CLOSED) },
                onSearchClicked = { viewModel.getBooks(it) },
                onSearchTriggered = { viewModel.updateSearchState(SearchToolbarState.OPEN)}
            )
        }
    ) {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            BooksStateScreen(
                booksUiState = uiState,
                retryAction = { viewModel.getBooks() },
                onBookClicked = onBookClicked
            )
        }
    }
}