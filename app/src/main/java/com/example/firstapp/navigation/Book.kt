package com.example.firstapp.navigation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color

data class Book(
    val title: String = "",
    val author: String = "",
    val read: Boolean = false,
    val bookType: BookType = BookType.Fiction
)

sealed class BookType(val foregroundColor: Color, val backgroundColor: Color) {
    data object Fiction : BookType(Color(0xFF21005D), Color(0xFFEADDFF))
    data object NonFiction : BookType(Color(0xFF062100), Color(0xFFD1F2D1))
}

val books = mutableStateListOf(
    Book("Catch-22", "Joseph Heller", true),
    Book("The Great Gatsby", "F. Scott Fitzgerald", true),
    Book("The Catcher in the Rye", "J.D. Salinger", true),
    Book("Nineteen Eighty-Four", "George Orwell", true),
    Book("The Lord of the Rings", "J.R.R. Tolkien", true),
    Book("The Hobbit", "J.R.R. Tolkien", false, BookType.NonFiction),
    Book("The Alchemist", "Paulo Coelho", true),
    Book("The Hunger Games", "Suzanne Collins", false, BookType.NonFiction),
    Book("The Da Vinci Code", "Dan Brown", false, BookType.NonFiction),
)
