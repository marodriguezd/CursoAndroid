package com.marodriguezd.firebasetutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * MainScreen es la pantalla principal de la aplicación, mostrando un mensaje de bienvenida o el
 * contenido principal.
 */
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Pantalla principal")
    }
}

/**
 * MainScreenPreview proporciona una vista previa de MainScreen dentro del entorno de desarrollo.
 */
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}