package com.example.firstapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// this is a small guess game
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun GuessState(modifier: Modifier = Modifier) {
    val states: List<String> = remember {
        listOf(
            "UP", "MP", "WB",
            "Bihar", "Telangana", "Jharkhand",
            "Goa", "Kerala", "Punjab"
        )
    }

    var guess by remember { mutableStateOf("") }
    var guessedState: String? by remember { mutableStateOf(null) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = guess,
            onValueChange = { guess = it },
            placeholder = { Text(text = "Enter your guess") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { guessedState = guess.trim() }
        ) {
            Text(text = "Find", style = MaterialTheme.typography.titleMedium)
        }

        Spacer(modifier = Modifier.height(24.dp))

        DisplayStates(states = states, guessedState = guessedState)
    }
}

@Composable
fun DisplayStates(
    modifier: Modifier = Modifier,
    states: List<String>,
    guessedState: String?
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(states) { state ->
            val isGuessed = guessedState?.equals(state, ignoreCase = true) == true
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (isGuessed) MaterialTheme.colorScheme.primaryContainer else Color.Transparent
                ),
                border = BorderStroke(.4.dp, MaterialTheme.colorScheme.onPrimaryContainer)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = state,
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (isGuessed) MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                    )
                }
            }
        }
    }
}

