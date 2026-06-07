package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapp.ui.theme.FirstAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),

                    ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding)
                    ) {
                        itemsIndexed(
                            listOf<String>(
                                "acorn", "blizzard", "citadel", "dynasty", "eclipse",
                                "falcon", "gargoyle", "harvest", "infinity", "javelin",
                                "kingdom", "lantern", "mirage", "nomad", "octopus",
                                "phantom", "quiver", "radiance", "sapphire", "tornado",
                                "universe", "vanguard", "willow", "xenon", "yosemite",
                                "zenith", "alchemy", "boulder", "cascade", "destiny",
                                "entropy", "fable", "glitch", "horizon", "illusion",
                                "journey", "kinetic", "legacy", "monolith", "nebula",
                                "odyssey", "pinnacle", "quantum", "resonance", "solitude",
                                "tundra", "utopia", "vortex", "wilderness", "zephyr"
                            )
                        ) { index, string ->
                            Text(
                                text = "$index - $string",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp)

                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {
    Box(
        modifier = modifier
            .background(Color.Red)
            .clickable {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                )
            }
    )
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth() // Ensure content fills card width
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize() // Ensure image fills the box
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.White
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.Black, fontSize = 16.sp))
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .height(400.dp)
            .padding(10.dp)
            .fillMaxSize(),
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Hello world",
            fontSize = 25.sp
        )

        val onClick = {
            println("clicked")
        }
        ElevatedButton(
            onClick = onClick,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ImageCardPreview() {
    FirstAppTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(Color.Red),
        ) { innerPadding ->

            val painter = painterResource(R.drawable.leetcodebadge)
            val description = "leetcode badge"
            val title = "leetcode badge"

            // Use a root container to handle Scaffold's innerPadding
            Box(
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .statusBarsPadding()
                    .padding(innerPadding)


            ) {
                ImageCard(
                    painter = painter,
                    contentDescription = description,
                    title = title,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}