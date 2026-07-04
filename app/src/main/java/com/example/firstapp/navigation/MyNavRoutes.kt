package com.example.firstapp.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class MyNavRoutes {
    @Serializable
    data object LoginScreen : MyNavRoutes()

    @Serializable
    data object HomeScreen : MyNavRoutes()
}