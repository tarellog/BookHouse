package com.example.bookhouse.ui.booksscreen.searchtoolbar

import androidx.compose.runtime.Composable

@Composable
fun ToolbarState(
    searchToolbarState: SearchToolbarState,
    searchText: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit
    ) {
    when (searchToolbarState) {
        SearchToolbarState.CLOSED -> { ClosedToolbar(onSearchTriggered = onSearchTriggered) }
        SearchToolbarState.OPEN -> {
            OpenToolbar(
                text = searchText,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClicked
            )
        }
    }
}