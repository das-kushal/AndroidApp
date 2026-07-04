package com.example.firstapp.navigation.utils


import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import java.util.UUID

data class BookVM(
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

suspend fun getBooks(): List<BookVM> {
    val books = listOf(
        BookVM(title = "Catch-22", author = "Joseph Heller", read = true),
        BookVM(title = "The Great Gatsby", author = "F. Scott Fitzgerald", read = true),
        BookVM(title = "The Catcher in the Rye", author = "J.D. Salinger", read = true),
        BookVM(title = "Nineteen Eighty-Four", author = "George Orwell", read = true),
        BookVM(title = "The Lord of the Rings", author = "J.R.R. Tolkien", read = true),
        BookVM(
            title = "The Hobbit",
            author = "J.R.R. Tolkien",
            read = false,
            bookType = BookType.NonFiction
        ),
        BookVM(title = "The Alchemist", author = "Paulo Coelho", read = true),
        BookVM(
            title = "The Hunger Games",
            author = "Suzanne Collins",
            read = false,
            bookType = BookType.NonFiction
        ),
        BookVM(
            title = "The Da Vinci Code",
            author = "Dan Brown",
            read = false,
            bookType = BookType.NonFiction
        ),
    )

    delay(1000)

    return books
}
