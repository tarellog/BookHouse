package com.example.bookhouse.data.repository

import com.example.bookhouse.data.model.Books

interface BooksRepository {

    suspend fun getBooks(searchQuery: String, maxResult: Int): List<Books>

}