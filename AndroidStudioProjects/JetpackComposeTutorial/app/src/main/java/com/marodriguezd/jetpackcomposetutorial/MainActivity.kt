package com.marodriguezd.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.marodriguezd.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComponent()
        }
    }
}

// Para evitar superposición de imagen y texto en este caso
@Composable
fun MyComponent() {
    Row {
        MyImage()
        MyTexts()
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "Mi imagen de prueba"
    )
}

@Composable
fun MyTexts() {
    // Puesto así saldrían superpuestos
    /*MyText("Hola Jetpack Compose!")
    MyText("¿Preparado?")*/

    // De esta manera los tendríamos en filas y orden de primero a último de arriba a abajo
    Column {
        MyText("Hola Jetpack Compose!")
        MyText("¿Preparado?")
    }
}

// Un componente composable es una función
@Composable
fun MyText(text: String) {
    Text(text)
}

// Para usar una preview debe ser composable y anotarlo como preview (ahorramos emulador)
@Preview
@Composable
fun PreviewComponents() {
    // Puesto así se superponen también
    /*MyImage()
    MyTexts()*/

    // De esta manera no se superponen sino que van a columnas
    MyComponent()
}