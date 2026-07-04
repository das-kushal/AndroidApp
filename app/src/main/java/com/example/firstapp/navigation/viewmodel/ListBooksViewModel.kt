package com.example.firstapp.navigation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.navigation.model.Book
import com.example.firstapp.navigation.model.getBooks
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListBooksViewModel : ViewModel() {
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books.asStateFlow()

    init {
        viewModelScope.launch {
            _books.value = getBooks()
        }
    }

    fun deleteBook(book: Book) {
        _books.value = _books.value.filter { it.id != book.id }
    }

    fun getBookById(id: String): Book? {
        return _books.value.find { it.id == id }
    }

    fun updateBook(updatedBook: Book) {
        _books.value = _books.value.map {
            if (it.id == updatedBook.id) updatedBook else it
        }
    }
}
