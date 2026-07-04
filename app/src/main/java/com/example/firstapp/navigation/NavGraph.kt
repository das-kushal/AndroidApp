package com.example.firstapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.firstapp.navigation.viewmodel.ListBooksViewModel

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val viewModel = ListBooksViewModel()

    NavHost(
        navController = navController,
        startDestination = MyNavRoutes.LoginScreen
    ) {
        composable<MyNavRoutes.LoginScreen> {
            LoginScreenUI(navController)
        }

        composable<MyNavRoutes.HomeScreen> {
            HomeScreenUI(modifier, navController, viewModel)
        }

        composable<MyNavRoutes.EditBookScreen> { backStackEntry ->
            val editBookRoute: MyNavRoutes.EditBookScreen = backStackEntry.toRoute()
            EditBookScreenUI(modifier, navController, viewModel, editBookRoute.bookId)
        }
    }

}
