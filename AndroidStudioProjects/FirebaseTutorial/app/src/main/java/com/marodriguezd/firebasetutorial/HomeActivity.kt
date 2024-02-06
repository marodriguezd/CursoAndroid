package com.marodriguezd.firebasetutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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

@Composable
fun HomeActivity(email: String, proveedor: String, onLogout: () -> Unit) {
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
                text = "Proveedor: $proveedor",
                modifier = Modifier.padding(bottom = 8.dp) // Agregar un poco de espacio debajo del texto
            )
            Spacer(modifier = Modifier.height(16.dp))  // Espacio entre el texto y el botón
            Button(
                onClick = onLogout,
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

@Preview(showBackground = true)
@Composable
fun HomeActivityPreview() {
    HomeActivity("mock@mock.mock", "Google", onLogout = {})
}