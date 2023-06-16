package com.example.bookhouse.network.model

data class BookModel(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)