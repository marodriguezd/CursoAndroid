package com.marodriguezd.firebasetutorial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.marodriguezd.firebasetutorial.*

/**
 * Define la navegación de la aplicación utilizando Compose Navigation.
 * Se configuran las rutas y los destinos de navegación de la aplicación.
 */
@Composable
fun AppNavigation() {
    // Se inicializa el NavController, que gestiona la navegación entre composables.
    val navController = rememberNavController()

    // Define el host de navegación, especificando el destino de inicio y configurando las rutas.
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {

        // Define la ruta y el composable para la pantalla de inicio (SplashScreen).
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }

        // Define la ruta y el composable para la pantalla principal (MainScreen).
        composable(AppScreens.MainScreen.route) {
            MainScreen()
        }

        // Define la ruta y el composable para la actividad de autenticación (AuthActivity).
        composable(route = AppScreens.AuthActivity.route) {
            AuthActivity { email, provider ->
                // Navega a HomeActivity pasando email y provider como argumentos.
                val route = AppScreens.HomeActivity.createRoute(email, provider)
                navController.navigate(route) {
                    // Limpia el stack de navegación hasta AuthActivity.
                    popUpTo(AppScreens.AuthActivity.route) { inclusive = true }
                }
            }
        }

        // Define la ruta y el composable para la actividad principal (HomeActivity),
        // incluyendo los argumentos necesarios para su inicialización.
        composable(
            route = AppScreens.HomeActivity.route,
            arguments = listOf(
                navArgument("email") { type = NavType.StringType },
                navArgument("provider") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            HomeActivity(
                email = backStackEntry.arguments?.getString("email") ?: "",
                provider = ProviderType.valueOf(
                    backStackEntry.arguments?.getString("provider") ?: ProviderType.BASIC.name
                )
            ) {
                // Navega hacia AuthActivity cuando se cierra sesión, limpiando el stack de navegación.
                navController.navigate(AppScreens.AuthActivity.route) {
                    // Elimina todas las pantallas anteriores del stack y restaura el estado si es necesario.
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }
}