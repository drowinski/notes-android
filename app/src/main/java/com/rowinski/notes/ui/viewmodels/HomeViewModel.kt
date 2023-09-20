package com.rowinski.notes.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rowinski.notes.data.database.models.Note
import com.rowinski.notes.data.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val notes: List<Note> = emptyList()
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            noteRepository.notesFlow.collect { notes ->
                _uiState.update { it.copy(notes = notes) }
            }
        }
    }

    suspend fun createEmptyNote(): Long {
        return noteRepository.create(Note(title = "New Note", text = "This is a new note."))
    }
}