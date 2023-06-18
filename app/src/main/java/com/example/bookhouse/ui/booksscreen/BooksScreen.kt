package com.example.bookhouse.ui.booksscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookhouse.R
import com.example.bookhouse.ui.BooksViewModel

@Composable
fun BooksScreen(modifier: Modifier = Modifier) {
    val viewModel: BooksViewModel = viewModel(factory = BooksViewModel.Factory)
    val uiState by viewModel.booksUiState.collectAsState()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) }) }
    ) {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            BooksStateScreen(
                booksUiState = uiState,
                retryAction = { viewModel.getBooks() }
            )
        }
    }
}