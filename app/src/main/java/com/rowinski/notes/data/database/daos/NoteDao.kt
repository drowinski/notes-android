package com.rowinski.notes.data.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rowinski.notes.data.database.models.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note): Long

    @Update
    suspend fun update(note: Note): Int

    @Delete
    suspend fun delete(note: Note): Int

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getById(id: Long): Note

    @Query("SELECT * FROM note WHERE id = :id")
    fun getByIdAsFlow(id: Long): Flow<Note>

    @Query("SELECT * FROM note")
    suspend fun getAll(): List<Note>

    @Query("SELECT * FROM note")
    fun getAllAsFlow(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE folder_id = :folderId")
    suspend fun getAllByFolderId(folderId: Long): List<Note>
}