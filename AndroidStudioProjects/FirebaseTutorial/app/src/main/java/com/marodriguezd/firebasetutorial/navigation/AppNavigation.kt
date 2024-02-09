package com.marodriguezd.firebasetutorial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.marodriguezd.firebasetutorial.AuthActivity
import com.marodriguezd.firebasetutorial.HomeActivity
import com.marodriguezd.firebasetutorial.MainScreen
import com.marodriguezd.firebasetutorial.ProviderType
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
        composable(route = AppScreens.AuthActivity.route) { backStackEntry ->
            AuthActivity { email, provider ->
                // Navegar a HomeActivity con argumentos
                val route = AppScreens.HomeActivity.createRoute(email, ProviderType.BASIC)
                navController.navigate(route) {
                    popUpTo(AppScreens.AuthActivity.route) { inclusive = true }
                }
            }
        }
        composable(
            AppScreens.HomeActivity.route,
            arguments = listOf(
                navArgument("email") { type = NavType.StringType },
                navArgument("provider") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val providerType = ProviderType.valueOf(
                backStackEntry.arguments?.getString("provider") ?: ProviderType.BASIC.name
            )
            HomeActivity(
                email = backStackEntry.arguments?.getString("email") ?: "",
                provider = providerType
            ) {
                // TODO: Definir lógica de cierre de sesión
            }
        }
    }
}