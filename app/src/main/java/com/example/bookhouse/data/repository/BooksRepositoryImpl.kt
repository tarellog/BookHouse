package com.example.bookhouse.data.repository

import com.example.bookhouse.data.model.Books
import com.example.bookhouse.network.service.ApiService

class BooksRepositoryImpl(
    private val apiService: ApiService
) : BooksRepository {

    override suspend fun getBooks(searchQuery: String, maxResult: Int): List<Books> =
        apiService.getBooks(
            searchQuery = searchQuery,
            maxResults = maxResult
        ).items.map { item ->
            Books(
                title = item.volumeInfo.title,
                previewLink = item.volumeInfo.previewLink,
                imageLink = item.volumeInfo.imageLinks.thumbnail
            ) }
}