package com.marodriguezd.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marodriguezd.hellojetpackcompose.ui.theme.HelloJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {  // Esto sería nuestra Activity. Tod0 esto se pinta en la pantalla de la app
            // Text(text = "Hola Jetpack Compose")  // Esta fue la primera prueba
            // Para no sobrecomplicar tod0 esto podemos usar diferentes elementos composables.
            // Dividir el código composable en diferentes bloques ayuda a releer y reutilizar.
            PersonalData(name = "Miguel Angel")
        }
    }

    @Composable // Necesario siempre para que las funciones sean composables.
    private fun PersonalData(name: String) {
        // Para aplicar un tema Material Design hay que hacerlo como elemento superior
        MaterialTheme() {
            // Para que no se superpongan los texts deberíamos ponerlos en columnas con Column
            // Además le podemos añadir modificadores
            Column(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Para añadir una imagen desde código tras haberlo hecho en el Resource Manager solo es
                Image(
                    painter = painterResource(R.drawable.tf2_coconut_remastered),
                    contentDescription = "TF2 Coconut",
                    modifier = Modifier.height(200.dp))

                // Elemento para separar en este caso foto de texto por ejemplo
                Spacer(modifier = Modifier.height(16.dp))

                // Una vez metido dentro de un MaterialTheme se pueden usar más tipografías.
                Text(text = "Mi nombre es $name", style = MaterialTheme.typography.headlineMedium)
                Text(text = "Soy programador")
                Text(text = "@marodriguezd")
            }
        }
    }

    // Con Jetpack Compose podemos ver cómo se va actualizando en tiempo real la interfaz.
    // Lo único que necesitamos hacer es un bloque anotado con @Preview antes del @Composable.
    @Preview
    @Composable
    fun PreviewPersonalData() {
        PersonalData(name = "Miguel Angel")
    }
}

