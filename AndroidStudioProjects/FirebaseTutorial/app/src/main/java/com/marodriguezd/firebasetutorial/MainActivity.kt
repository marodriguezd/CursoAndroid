package com.marodriguezd.firebasetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.firebase.analytics.FirebaseAnalytics
import com.marodriguezd.firebasetutorial.navigation.AppNavigation
import com.marodriguezd.firebasetutorial.ui.theme.FirebaseTutorialTheme

/**
 * MainActivity sirve como punto de entrada para la aplicación, estableciendo el tema
 * y navegación inicial basada en el estado de autenticación del usuario.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    logAnalyticsEvent()
                    navigateBasedOnAuthentication()
                }
            }
        }
    }

    /**
     * Registra un evento en Firebase Analytics al iniciar la aplicación.
     */
    fun logAnalyticsEvent() {
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle().apply {
            putString("message", "Integración de Firebase completa")
        }
        analytics.logEvent("InitScreen", bundle)
    }

    /**
     * Determina la navegación inicial basada en el estado de autenticación del usuario,
     * dirigiéndolo a HomeActivity si está autenticado o a AppNavigation si no lo está.
     */
    @Composable
    fun navigateBasedOnAuthentication() {
        val (email, provider) = getUserData(this)
        if (email != null && provider != null) {
            HomeActivity(email, ProviderType.valueOf(provider)) {
                // Lógica para cerrar sesión
            }
        } else {
            // Usuario no autenticado, mostrar pantalla de autenticación
            // Splash + AuthActivity
            AppNavigation()
        }
    }
}

/**
 * HE SUPRIMIDO EL SPLASH DE MANERA TEMPORAL PARA NO PERDER MÁS TIEMPO.
 */