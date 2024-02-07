package com.marodriguezd.firebasetutorial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marodriguezd.firebasetutorial.AuthActivity
import com.marodriguezd.firebasetutorial.HomeActivity
import com.marodriguezd.firebasetutorial.MainScreen
import com.marodriguezd.firebasetutorial.SplashScreen

@Composable
fun AppNavigation() {
    // Crear controlador de navegación por defecto
    val navController = rememberNavController()  // remember para que recuerde donde está

    // Crear el host
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route,
        ) {  // Esto reemplaza al builder
        composable(AppScreens.SplashScreen.route) {
            // El controlador de navegación es quien permite navegar.
            SplashScreen(navController)
        }
        composable(AppScreens.MainScreen.route) {
            MainScreen()
        }
        composable(AppScreens.AuthActivity.route) {
            AuthActivity(
                onNavigateToHome = {
                    // Navegar a HomeActivity
                    navController.navigate(AppScreens.HomeActivity.route) {
                        popUpTo(AppScreens.AuthActivity.route)
                    }
                }
            )
        }
        composable(AppScreens.HomeActivity.route) {
            // TODO: RETOCAR WACHO, ESTO ES TEMPORAL
            HomeActivity("mock@mock.mock", "Google") {}
        }
    }
}