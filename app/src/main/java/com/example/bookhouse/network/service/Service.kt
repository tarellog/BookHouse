package com.example.bookhouse.network.service

import com.example.bookhouse.data.repository.BooksRepository

interface Service {
    val booksRepository: BooksRepository
}