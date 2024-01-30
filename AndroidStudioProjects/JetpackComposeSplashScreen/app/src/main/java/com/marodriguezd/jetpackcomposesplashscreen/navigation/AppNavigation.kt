package com.marodriguezd.jetpackcomposesplashscreen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marodriguezd.jetpackcomposesplashscreen.MainScreen
import com.marodriguezd.jetpackcomposesplashscreen.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()  // Creamos un navController por defecto
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route
    ) {
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController)  // El navController es el que nos da la capacidad de navegación.
        }
        composable(AppScreens.MainScreen.route) {
            MainScreen()
        }
    }
}