package com.example.firstapp.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class MyNavRoutes {
    @Serializable
    object LoginScreen : MyNavRoutes()

    @Serializable
    object HomeScreen : MyNavRoutes()
}