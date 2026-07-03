package com.example.firstapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapp.navigation.NavGraph
import com.example.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                ModalNavigationDrawer(
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    contentDescription = "Go to Home Screen",
                                    icon = Icons.Default.Home
                                ),
                                MenuItem(
                                    id = "settings",
                                    title = "Settings",
                                    contentDescription = "Go to Settings Screen",
                                    icon = Icons.Default.Settings
                                ),
                                MenuItem(
                                    id = "help",
                                    title = "Help",
                                    contentDescription = "Go to get Help Screen",
                                    icon = Icons.Default.Info
                                ),
                            )
                        ) { }
                    }
                ) {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize(),


                        ) { innerPadding ->
//                    TopBar(modifier = Modifier.padding(innerPadding))
//                        Hello(modifier = Modifier.padding(innerPadding))
                        NavGraph(modifier = Modifier.padding(innerPadding))

                    }
                }

            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current.applicationContext
    TopAppBar(
        title = { Text("Hello world") },
        navigationIcon = {
            IconButton(
                onClick = {
                    Toast.makeText(context, "Checking", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Checking")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Green,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White

        ),
        actions = {
            IconButton(
                onClick = {
                    Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Profile")
            }
            IconButton(
                onClick = {
                    Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            }
            IconButton(
                onClick = {
                    Toast.makeText(context, "More", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun AlertDialogExample() {
    var openDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Alert Dialog Box",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray
                )

                IconButton(
                    onClick = { openDialog = true },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.LightGray
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete"
                    )
                }
            }
        }

        if (openDialog) {
            AlertDialog(
                onDismissRequest = { openDialog = false },
//                icon = {
//                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Item")
//                },
                title = {
                    Text("Delete Item")
                },
                text = {
                    Text("Are you sure you want to delete this item?")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Item has been deleted successfully",
                                Toast.LENGTH_SHORT
                            ).show()

                            openDialog = false
                        }
                    ) { Text("Delete") }
                },
                dismissButton = {
                    Button(
                        onClick = { openDialog = false }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

@Composable
fun Hello(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Hello World!",
            fontWeight = FontWeight.Bold
        )
    }
}