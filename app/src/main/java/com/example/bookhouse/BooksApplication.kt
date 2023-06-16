package com.example.bookhouse

import android.app.Application
import com.example.bookhouse.network.service.Service
import com.example.bookhouse.network.service.ServiceImpl

class BooksApplication : Application() {

    lateinit var service: Service

    override fun onCreate() {
        super.onCreate()
        service = ServiceImpl()
    }

}