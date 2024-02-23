package com.marodriguezd.firebasetutorial.navigation

import android.net.Uri
import com.marodriguezd.firebasetutorial.ProviderType

/**
 * Define las rutas de navegación de la aplicación como una clase sellada.
 * Restringe la creación de subclases fuera de este archivo, lo que permite un manejo seguro de las rutas.
 */
sealed class AppScreens(val route: String) {
    // Representa la pantalla de inicio de la aplicación.
    object SplashScreen: AppScreens("splash_screen")

    // Representa la pantalla principal de la aplicación.
    object MainScreen: AppScreens("main_screen")

    // Representa la pantalla de autenticación.
    object AuthActivity: AppScreens("auth_screen")

    // Representa la pantalla de inicio después de la autenticación, con parámetros dinámicos en la ruta.
    object HomeActivity: AppScreens("home_screen/{email}/{provider}") {
        /**
         * Genera la ruta hacia HomeActivity con los parámetros especificados.
         *
         * @param email El correo electrónico del usuario, codificado para ser parte de la URL.
         * @param provider El proveedor de autenticación utilizado.
         * @return La ruta formateada con los parámetros incluidos.
         */
        fun createRoute(email: String, provider: ProviderType): String {
            // return "home_screen/$email/$provider"
            return "home_screen/${Uri.encode(email)}/${provider.name}"
        }
    }
}