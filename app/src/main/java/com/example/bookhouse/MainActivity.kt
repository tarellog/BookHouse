package com.example.bookhouse

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.core.content.ContextCompat
import com.example.bookhouse.ui.booksscreen.BooksScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksScreen(
                onBookClicked = {
                    ContextCompat.startActivity(
                        this,
                        Intent(Intent.ACTION_VIEW, Uri.parse(it.previewLink)),
                        null
                    )
                }
            )
        }
    }

}