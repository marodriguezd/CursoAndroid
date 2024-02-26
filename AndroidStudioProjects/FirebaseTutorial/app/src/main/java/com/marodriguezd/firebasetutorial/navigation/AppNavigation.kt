package com.marodriguezd.firebasetutorial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.marodriguezd.firebasetutorial.*

/**
 * Configura y gestiona la navegación de la aplicación utilizando Jetpack Compose Navigation.
 */
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(AppScreens.MainScreen.route) {
            MainScreen()
        }

        composable(route = AppScreens.AuthActivity.route) {
            AuthActivity { email, provider ->
                navController.navigateToHomeActivity(email, provider)
            }
        }

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
                navController.navigateToAuthActivity()
            }
        }
    }
}

private fun androidx.navigation.NavController.navigateToHomeActivity(
    email: String,
    provider: ProviderType
) {
    val route = AppScreens.HomeActivity.createRoute(email, provider)
    navigate(route) {
        popUpTo(AppScreens.AuthActivity.route) { inclusive = true }
    }
}

private fun androidx.navigation.NavController.navigateToAuthActivity() {
    navigate(AppScreens.AuthActivity.route) {
        popUpTo(graph.startDestinationId) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}