package com.example.bookhouse.network.service

import com.example.bookhouse.network.model.BookModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("volumes")

    suspend fun getBooks(
        @Query("q") searchQuery: String,
        @Query("maxResults") maxResults: Int
    ): BookModel

}