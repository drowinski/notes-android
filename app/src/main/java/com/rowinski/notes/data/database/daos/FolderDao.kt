package com.rowinski.notes.data.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rowinski.notes.data.database.models.Folder

@Dao
interface FolderDao {
    @Insert
    suspend fun insert(folder: Folder): Long

    @Update
    suspend fun update(folder: Folder): Int

    @Delete
    suspend fun delete(folder: Folder): Int

    @Query("SELECT * FROM folder WHERE id = :id")
    suspend fun getById(id: Long): Folder

    @Query("SELECT * FROM folder")
    suspend fun getAll(): List<Folder>
}