package com.marodriguezd.firebasetutorial

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeActivity(email: String, provider: ProviderType, onLogout: () -> Unit) {
    val context = LocalContext.current  // Obtiene el contexto actual en un composable

    // Definir colores específicos
    val colorBotonLogout = Color(0xFFF57C00) // Firebase naranja

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center  // Centra el contenido de la Box verticalmente y horizontalmente
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start // Alinea el contenido del Column a la izquierda (Start)
        ) {
            Text(
                text = "Email: $email",
                modifier = Modifier.padding(bottom = 8.dp) // Agregar un poco de espacio debajo del texto
            )
            Text(
                text = "Proveedor: ${provider.name}",
                modifier = Modifier.padding(bottom = 8.dp) // Agregar un poco de espacio debajo del texto
            )
            Spacer(modifier = Modifier.height(16.dp))  // Espacio entre el texto y el botón
            Button(
                onClick = {
                    FirebaseAuth.getInstance().signOut()
                    clearUserData(context)  // Limpia los datos de usuario
                    context.startActivity(Intent(context, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    })
                    // onLogout()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorBotonLogout  // Usar el color Google azul 700 definido
                ),
                modifier = Modifier.fillMaxWidth()  // El botón ocupa tod0 el ancho disponible
            ) {
                Text("Cerrar sesión")
            }
            // Puedes agregar más elementos aquí si es necesario
        }
    }
}

const val PREFS_FILE = "prefs_file"

fun saveUserData(context: Context, email: String, provider: String) {
    val prefs = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putString("email", email)
    editor.putString("provider", provider)
    editor.apply()  // o editor.commit() para una escritura sincrónica
}

fun getUserData(context: Context): Pair<String?, String?> {
    val prefs = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
    val email = prefs.getString("email", null)
    val provider = prefs.getString("provider", null)
    return Pair(email, provider)
}

fun clearUserData(context: Context) {
    val prefs = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
    prefs.edit().clear().apply()
}