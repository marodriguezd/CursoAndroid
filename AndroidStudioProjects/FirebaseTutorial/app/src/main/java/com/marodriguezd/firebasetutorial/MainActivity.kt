package com.marodriguezd.firebasetutorial

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.marodriguezd.firebasetutorial.navigation.AppNavigation
import com.marodriguezd.firebasetutorial.ui.theme.FirebaseTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Splash + AuthActivity
                    AppNavigation()

                    // Analytics Event
                    // Con este bloque pasamos eventos personalizados a Google Analytics
                    // Podremos ver tod0 esto en nuestra consola de Firebase
                    val analytics = FirebaseAnalytics.getInstance(this)
                    val bundle = Bundle()  // Para pasar los parámetros necesarios
                    bundle.putString("message", "Integración de Firebase completa")  // Dar clave:valor
                    analytics.logEvent("InitScreen", bundle)  // Nombre del log y bundle
                }
            }
        }
    }
}

/**  PARA BIG-AGI
 * Ahora para el tema de la autenticación con Google se usará el ProviderType.GOOGLE,
 * además ya he añadido las dependencias necesarias en el Gradle. Pero primero lo que se va a
 * implementar es el que se quede autenticado el usuario si se ha autenticado y cerrado la app,
 * para que al abrirla se mantenga autenticado guardando los datos de que se ha autenticado.
 */