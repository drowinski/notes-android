package com.rowinski.notes.data.repositories

import com.rowinski.notes.data.database.daos.NoteDao
import com.rowinski.notes.data.database.models.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {
    val notesFlow: Flow<List<Note>> = noteDao.getAllAsFlow()

    suspend fun create(note: Note): Long = noteDao.insert(note)
}