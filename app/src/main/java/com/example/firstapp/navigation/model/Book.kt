package com.example.firstapp.navigation.model

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import java.util.UUID

data class Book(
    val id: String = UUID.randomUUID().toString(),
    val title: String = "",
    val author: String = "",
    val read: Boolean = false,
    val bookType: BookType = BookType.Fiction
)

sealed class BookType(val foregroundColor: Color, val backgroundColor: Color) {
    data object Fiction : BookType(Color(0xFF21005D), Color(0xFFEADDFF))
    data object NonFiction : BookType(Color(0xFF062100), Color(0xFFD1F2D1))
}

suspend fun getBooks(): List<Book> {
    val books = listOf(
        Book(title = "Catch-22", author = "Joseph Heller", read = true),
        Book(title = "The Great Gatsby", author = "F. Scott Fitzgerald", read = true),
        Book(title = "The Catcher in the Rye", author = "J.D. Salinger", read = true),
        Book(title = "Nineteen Eighty-Four", author = "George Orwell", read = true),
        Book(title = "The Lord of the Rings", author = "J.R.R. Tolkien", read = true),
        Book(title = "The Hobbit", author = "J.R.R. Tolkien", read = false, bookType = BookType.NonFiction),
        Book(title = "The Alchemist", author = "Paulo Coelho", read = true),
        Book(title = "The Hunger Games", author = "Suzanne Collins", read = false, bookType = BookType.NonFiction),
        Book(title = "The Da Vinci Code", author = "Dan Brown", read = false, bookType = BookType.NonFiction),
    )

    delay(1000)

    return books
}
