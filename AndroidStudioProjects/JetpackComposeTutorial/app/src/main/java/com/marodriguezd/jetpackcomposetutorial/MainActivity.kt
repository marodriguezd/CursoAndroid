package com.marodriguezd.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marodriguezd.jetpackcomposetutorial.ui.theme.*
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Los temas también se añaden como elemento composable. En este caso como elemento superior.
            JetpackComposeTutorialTheme {
                // De esta forma además tod0 hereda de material design y lo predispuesto por Google.
                MyComponent()
            }
        }
    }
}

// Para evitar superposición de imagen y texto en este caso
@Composable
fun MyComponent() {
    // Vamos a añadirle un modificador. Hay que ir concatenando cada modificación ya que es funcional.
    // Cada modificador realiza cambios sobre el elemento actual y lo devuelve modificado, devolviendo
    // un nuevo modifier. Al que le podemos seguir aplicando nuevos modificadores. Se ejecutan en orden.
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)) {
        MyImage()
        MyTexts()
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "Mi imagen de prueba",
        // Es importante el orden de los modificadores ya que si hacermos gris el cuadrado y luego
        // círculo no irá bien. Sería primero círculo y luego gris.
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun MyTexts() {
    // Puesto así saldrían superpuestos
    /*MyText("Hola Jetpack Compose!")
    MyText("¿Preparado?")*/

    // De esta manera los tendríamos en filas y orden de primero a último de arriba a abajo
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText("Hola Jetpack Compose!",
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.bodyMedium)
        // También hay modificadores para meter espaciado en anchura y/o altura
        Spacer(modifier = Modifier.height(16.dp))
        MyText("¿Preparado?",
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodySmall)
    }
}

// Un componente composable es una función
@Composable
fun MyText(text: String, color: Color, style: androidx.compose.ui.text.TextStyle) {
    Text(text, color = color, style = style)
}

// Para usar una preview debe ser composable y anotarlo como preview (ahorramos emulador)
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponents() {
    // Puesto así se superponen también
    /*MyImage()
    MyTexts()*/

    // De esta manera no se superponen sino que van a columnas
    JetpackComposeTutorialTheme {
        MyComponent()
    }
}