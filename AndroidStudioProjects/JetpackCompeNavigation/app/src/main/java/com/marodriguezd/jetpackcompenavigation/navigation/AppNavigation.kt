package com.marodriguezd.jetpackcompenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.marodriguezd.jetpackcompenavigation.screens.FirstScreen
import com.marodriguezd.jetpackcompenavigation.screens.SecondScreen

@Composable
fun AppNavigation() {  // Se va a encargar de gestionar y conocer las pantallas de la app.
    val navController =
        rememberNavController()  // Esta constante hay que propagarla entre todas las pantallas. Se encarga de guardar el estado de navegación entre ellas.
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route) {
        // Esto estará formado por diferentes composables. Cada uno designando cada una de las pantallas.
        composable(route = AppScreens.FirstScreen.route) {
            FirstScreen(navController)
        }
        composable(route = AppScreens.SecondScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })
        )
        {
            SecondScreen(navController, it.arguments?.getString("text"))  // Posibilidad de nulo
        }
    }
}