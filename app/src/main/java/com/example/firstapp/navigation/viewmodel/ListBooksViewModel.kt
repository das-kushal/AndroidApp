package com.example.firstapp.navigation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.navigation.utils.BookVM
import com.example.firstapp.navigation.utils.getBooks
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListBooksViewModel : ViewModel() {
    private val _books = MutableStateFlow<List<BookVM>>(emptyList())
    val books: StateFlow<List<BookVM>> = _books.asStateFlow()

    init {
        viewModelScope.launch {
            _books.value = getBooks()
        }
    }

    fun deleteBook(book: BookVM) {
        _books.value = _books.value.filter { it.id != book.id }
    }

    fun getBookById(id: String): BookVM? {
        return _books.value.find { it.id == id }
    }

    fun updateBook(updatedBook: BookVM) {
        _books.value = _books.value.map {
            if (it.id == updatedBook.id) updatedBook else it
        }
    }
}
