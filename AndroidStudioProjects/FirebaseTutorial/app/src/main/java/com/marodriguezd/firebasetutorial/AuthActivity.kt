package com.marodriguezd.firebasetutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AuthActivity(onNavigateToHome: () -> Unit) {
    // Estados para almacenar el texto ingresado por el usuario
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var showDialog by remember {
        mutableStateOf(false)
    }
    var errorMessage by remember {
        mutableStateOf("")
    }
    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),  // Agregar un poco de padding para no pegar los elementos a los bordes
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Campo de texto para el email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,  // Para que el TextField sea de una sola línea
            modifier = Modifier.fillMaxWidth()  // Para que ocupe tod0 el ancho disponible
        )

        Spacer(modifier = Modifier.height(8.dp))  // Espacio entre los TextFields

        // Campo de texto para la contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))  // Espacio entre el TextField y el Button

        // Definir colores específicos
        val colorBotonRegistrar = Color(0xFF1967D2) // Google azul 700
        val colorBotonAcceder = Color(0xFF1B3A57) // Firebase azul marino

        // Fila para contener ambos botones (Registrar y Acceder)
        Row(
            modifier = Modifier.fillMaxWidth(),  // La fila ocupa todo el ancho disponible
            horizontalArrangement = Arrangement.spacedBy(8.dp)  // Espacio entre los botones
        ) {
            // Botón para registrar
            Button(
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        FirebaseAuth.getInstance()
                            .createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    onNavigateToHome()
                                } else {
                                    errorMessage = task.exception?.message ?: "Error desconocido"
                                    showDialog = true
                                }
                            }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorBotonRegistrar  // Usar el color Google azul 700 definido
                ),
                modifier = Modifier.weight(1f)  // Cada botón obtiene la mitad del espacio
            ) {
                Text("Registrar")
            }

            // Diálogo de alerta
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Error") },
                    text = { Text(errorMessage) },
                    confirmButton = {
                        Button(
                            onClick = { showDialog = false }
                        ) {
                            Text("Aceptar")
                        }
                    }
                )
            }

            // Botón para acceder
            Button(
                onClick = {},  // De momento ignorado
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorBotonAcceder  // Usar el color Firebase azul marino definido
                ),
                modifier = Modifier.weight(1f)  // Cada botón obtiene la mitad del espacio
            ) {
                Text("Acceder")
            }
        }
    }
}