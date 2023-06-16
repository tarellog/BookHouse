package com.example.bookhouse.network.service

import com.example.bookhouse.data.repository.BooksRepository
import com.example.bookhouse.data.repository.BooksRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

class ServiceImpl: Service {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val booksRepository: BooksRepository by lazy { BooksRepositoryImpl(apiService) }

}