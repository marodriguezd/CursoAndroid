package com.marodriguezd.jetpackcomposesplashscreen.navigation

sealed class AppScreens(val route: String) {
    // Definición de los dos objetos que representarán las dos pantallas que tenemos.
    // Esta clase la usamos como "abstracta" para definir los mapeos.
    object SplashScreen: AppScreens("splash_screen")
    object MainScreen: AppScreens("main_screen")
}