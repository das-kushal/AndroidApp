package com.example.firstapp.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.firstapp.navigation.utils.BookVM
import com.example.firstapp.navigation.utils.BookType
import com.example.firstapp.navigation.viewmodel.ListBooksViewModel

@Composable
fun EditBookScreenUI(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: ListBooksViewModel,
    bookId: String
) {
    val book = remember { viewModel.getBookById(bookId) }

    if (book == null) {
        navController.popBackStack()
        return
    }

    var title by remember { mutableStateOf(book.title) }
    var author by remember { mutableStateOf(book.author) }
    var isFiction by remember { mutableStateOf(book.bookType is BookType.Fiction) }
    var isRead by remember { mutableStateOf(book.read) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Edit Book", style = MaterialTheme.typography.headlineMedium)

        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = author,
            onValueChange = { author = it },
            label = { Text("Author") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Type", style = MaterialTheme.typography.titleMedium)
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = isFiction,
                onClick = { isFiction = true }
            )
            Text("Fiction", modifier = Modifier.padding(start = 8.dp))
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            RadioButton(
                selected = !isFiction,
                onClick = { isFiction = false }
            )
            Text("Non-Fiction", modifier = Modifier.padding(start = 8.dp))
        }

        Text("Status", style = MaterialTheme.typography.titleMedium)
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = isRead,
                onClick = { isRead = true }
            )
            Text("Read", modifier = Modifier.padding(start = 8.dp))
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            RadioButton(
                selected = !isRead,
                onClick = { isRead = false }
            )
            Text("Not Read", modifier = Modifier.padding(start = 8.dp))
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                val updatedBook = book.copy(
                    title = title,
                    author = author,
                    bookType = if (isFiction) BookType.Fiction else BookType.NonFiction,
                    read = isRead
                )
                viewModel.updateBook(updatedBook)
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text("Save Changes")
        }
    }
}
