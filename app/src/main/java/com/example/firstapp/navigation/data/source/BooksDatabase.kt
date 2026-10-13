package com.example.firstapp.navigation.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.firstapp.navigation.domain.model.Book

@Database(entities = [Book::class], version = 1)
abstract class BooksDatabase : RoomDatabase() {

    abstract val dao: BooksDao

    companion object {
        const val DATABASE_NAME = "books.db"
    }
}