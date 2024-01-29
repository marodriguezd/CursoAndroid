package com.marodriguezd.biometricauth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.biometric.BiometricPrompt.PromptInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.marodriguezd.biometricauth.ui.theme.BiometricAuthTheme

class MainActivity :
    AppCompatActivity() {  // Cambiamos la herencia para poder usar bien el tema de biometría
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BiometricAuthTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Auth()
                }
            }
        }

        // Para iniciar la autentificación en el momento en el que se inicie la vista
        setupAuth()
    }

    // Preparación de la app para autentificación en el momento que se inicie
    // Private methods

    private var canAuthenticate = false
    private lateinit var promptInfo: BiometricPrompt.PromptInfo  // lateinit es porque se va a definir en tiempo de ejecución. Solo se definirá si el dispositivo se puede autenticar.

    private fun setupAuth() {

        // Importante que el BiometricManager sea el de androix
        if (BiometricManager.from(this).canAuthenticate(
                BiometricManager.Authenticators.BIOMETRIC_STRONG
                        or BiometricManager.Authenticators.DEVICE_CREDENTIAL
            ) == BiometricManager.BIOMETRIC_SUCCESS
        ) {  // El Strong hace referencia a los métodos de autentificación mediante huella o escáner facial. El DEVICE_CREDENTIAL al clásico de patrón, etc.
            canAuthenticate = true

            promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Autenticación biométrica")
                .setSubtitle("Autentícate utilizando el sensor biométrico")
                .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG
                        or BiometricManager.Authenticators.DEVICE_CREDENTIAL)
                .build()
        }
    }

    // Para cuando pulsamos el botón autenticar
    private fun authenticate(auth: (auth: Boolean) -> Unit) {  // Esto es de manera asíncrona. Utilizando estructura de clausure(?)...

        if (canAuthenticate) {
            // En caso positivo mostrar el diálogo del sistema.
            BiometricPrompt(this, ContextCompat.getMainExecutor(this),  // This es la activity asociada, obtener el executor principal con ContextCompat... Y le pasamos el contexto con this también.
                object: BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)  // Esto es si ha ido perfecto.

                        auth(true)
                    }  // Y este es su callback para comprobar si se ha hecho de forma correcta o no.
                }).authenticate(promptInfo)  // Con esto último mostramos lo que queremos que muestre.
        } else {
            auth(true)
        }
    }

    // Parte de composables

    @Composable
    fun Auth() {

        // En Jetpack Compose para trabajar con variables deben de ser mutables. Normalmente son constantes...
        // Porque entre otras cosas definimos estructuras visuales estáticas.
        var auth by remember { mutableStateOf(false) }  // Esto representa autenticado o no. Recargando interfaz

        Column(
            modifier = Modifier
                .background(if (auth) Color.Green else Color.Red)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                if (auth) "Estás autenticado" else "Necesitas autenticarte",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(8.dp))

            Button(onClick = {
                // Para volver atrás y cerrar en caso de ya estar autenticados.
                if (auth) {
                    auth = false
                } else {
                    authenticate {
                        auth =
                            it  // Igualamos la variable dinámica auth al valor de retorno de la operación de autenticación.
                    }
                }
            }) {
                Text(if (auth) "Cerrar" else "Autenticar")
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        BiometricAuthTheme {
            Auth()
        }
    }
}

