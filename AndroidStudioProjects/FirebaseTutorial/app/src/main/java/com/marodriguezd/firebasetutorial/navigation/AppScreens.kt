package com.marodriguezd.firebasetutorial.navigation

import android.net.Uri
import com.marodriguezd.firebasetutorial.ProviderType

// sealed class es un tipo de clase abstracta especial que restringe el poder crear
// subclases fuera del propio archivo.
sealed class AppScreens(val route: String) {
    // Los objetos aquí dentro representan las "pantallas" conteniendo sus rutas/nombres.
    object SplashScreen: AppScreens("splash_screen")
    object MainScreen: AppScreens("main_screen")
    object AuthActivity: AppScreens("auth_screen")
    object HomeActivity: AppScreens("home_screen/{email}/{provider}") {
        fun createRoute(email: String, provider: ProviderType): String {
            // return "home_screen/$email/$provider"
            return "home_screen/${Uri.encode(email)}/${provider.name}"
        }
    }
}