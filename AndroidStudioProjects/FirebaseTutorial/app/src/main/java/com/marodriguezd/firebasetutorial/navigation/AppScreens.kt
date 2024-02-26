package com.marodriguezd.firebasetutorial.navigation

import android.net.Uri
import com.marodriguezd.firebasetutorial.ProviderType

/**
 * Representa las pantallas de la aplicación y sus rutas asociadas, facilitando la navegación segura.
 */
sealed class AppScreens(val route: String) {
    object SplashScreen: AppScreens("splash_screen")
    object MainScreen: AppScreens("main_screen")
    object AuthActivity: AppScreens("auth_screen")

    /**
     * Representa la pantalla de inicio con parámetros dinámicos para email y proveedor en la ruta.
     */
    object HomeActivity: AppScreens("home_screen/{email}/{provider}") {
        /**
         * Construye la ruta hacia HomeActivity incluyendo el email y el proveedor como parámetros.
         *
         * @param email El correo electrónico del usuario, que será codificado para su inclusión en la URL.
         * @param provider El proveedor de autenticación del usuario.
         * @return La ruta formateada con los parámetros incluidos.
         */
        fun createRoute(email: String, provider: ProviderType): String {
            return "home_screen/${Uri.encode(email)}/${provider.name}"
        }
    }
}