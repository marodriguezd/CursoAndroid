package com.marodriguezd.jetpackcompenavigation.navigation

sealed class AppScreens(val route: String) {  // Necesitamos la ruta para que la app conozca por dónde debe ir.
    // Así tipamos y limitamos las pantallas de nuestra app.
    // Únicamente se podrán navegar a las pantallas que tenemos definidas aquí.
    // De esta manera aseguramos.
    object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen")
}