package com.example.bookhouse.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookhouse.BooksApplication
import com.example.bookhouse.data.repository.BooksRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BooksViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    private val _booksUiState = MutableStateFlow<BooksUiState>(BooksUiState.Loading)
    val booksUiState = _booksUiState.asStateFlow()

    init {
        getBooks()
    }

    private fun getBooks(query: String = "book", maxResult: Int = 40) {
        _booksUiState.tryEmit(BooksUiState.Loading)
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            Log.e("error", "Error", throwable)
            _booksUiState.tryEmit(BooksUiState.Error)
        }) {
                val result = booksRepository.getBooks(query, maxResult)
                Log.d("MyTag", result.toString())
                _booksUiState.tryEmit(BooksUiState.Success(booksRepository.getBooks(query, maxResult)))

        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BooksApplication)
                val booksRepository = application.service.booksRepository
                BooksViewModel(booksRepository = booksRepository)
            }
        }
    }

}