package com.rowinski.notes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.rowinski.notes.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(uiState.notes) { note ->
                Text(note.title + " --- " + note.text)
            }
        }

        Button(
            onClick = {
                coroutineScope.launch {
                    viewModel.createEmptyNote()
                }
            }
        ) {
            Text("Create note")
        }
    }
}