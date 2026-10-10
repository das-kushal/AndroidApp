package com.example.firstapp.navigation.data.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.firstapp.navigation.domain.model.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BooksDao {

    @Query("SELECT * FROM BOOKS")
    fun getBooks(): Flow<List<Book>>

    @Query("SELECT * FROM BOOKS WHERE id = :id")
    suspend fun getBookById(id: Int): Book?

    @Upsert
    suspend fun upsertBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)
}