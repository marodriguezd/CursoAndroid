package com.marodriguezd.firebasetutorial

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth

/**
 * Pantalla principal de la aplicación que muestra información del usuario y permite cerrar sesión.
 *
 * @param email Correo electrónico del usuario.
 * @param provider Proveedor de autenticación del usuario.
 * @param onLogout Callback invocado cuando el usuario cierra sesión.
 */
@Composable
fun HomeActivity(email: String, provider: ProviderType, onLogout: () -> Unit) {
    val context = LocalContext.current
    val logoutButtonColor = Color(0xFFF57C00) // Color naranja de Firebase

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            UserDetails(email = email, provider = provider)
            Spacer(modifier = Modifier.height(16.dp))
            LogoutButton(context = context, color = logoutButtonColor)
        }
    }
}

@Composable
fun UserDetails(email: String, provider: ProviderType) {
    Text(text = "Email: $email", modifier = Modifier.padding(bottom = 8.dp))
    Text(text = "Proveedor: ${provider.name}", modifier = Modifier.padding(bottom = 8.dp))
}

@Composable
fun LogoutButton(context: Context, color: Color) {
    Button(
        onClick = {
            FirebaseAuth.getInstance().signOut()
            clearUserData(context)
            navigateToMain(context)
        },
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Cerrar sesión")
    }
}

fun navigateToMain(context: Context) {
    context.startActivity(Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    })
}

const val PREFS_FILE = "prefs_file"

fun saveUserData(context: Context, email: String, provider: String) {
    val prefs = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE).edit()
    prefs.putString("email", email)
    prefs.putString("provider", provider)
    prefs.apply()
}

fun getUserData(context: Context): Pair<String?, String?> {
    val prefs = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
    return Pair(prefs.getString("email", null), prefs.getString("provider", null))
}

fun clearUserData(context: Context) {
    context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE).edit().clear().apply()
}