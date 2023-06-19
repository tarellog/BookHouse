package com.example.bookhouse.ui.booksscreen.booksitem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookhouse.R
import com.example.bookhouse.SampleData.listData
import com.example.bookhouse.data.model.Books

@Composable
fun BooksItem(
    books: Books,
    onBookClicked: (Books) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .requiredHeight(296.dp)
            .clickable { onBookClicked(books) },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = books.title,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(top = 4.dp, bottom = 8.dp)
            )
            AsyncImage(
                modifier = modifier.fillMaxWidth(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(books.imageLink.replace("http", "https"))
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun BooksItemPreview() {
    BooksItem(books = listData[3], onBookClicked = { listData})
}