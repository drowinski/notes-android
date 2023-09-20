package com.rowinski.notes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rowinski.notes.data.database.daos.FolderDao
import com.rowinski.notes.data.database.daos.NoteDao
import com.rowinski.notes.data.database.models.Folder
import com.rowinski.notes.data.database.models.Note

@Database(
    version = 1,
    entities = [Note::class, Folder::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun folderDao(): FolderDao

    companion object {
        private const val DB_NAME = "database.db"

        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
        }
    }
}