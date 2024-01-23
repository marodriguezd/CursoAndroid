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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marodriguezd.jetpackcomposetutorial.ui.theme.*

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Jetpack Compose!", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 2", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 3", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 4", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 5", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 6", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 7", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 8", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 9", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 10", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 11", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 12", "¿Preparado?"),
    MyMessage("Hola Jetpack Compose 13", "¿Preparado?")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Los temas también se añaden como elemento composable. En este caso como elemento superior.
            JetpackComposeTutorialTheme {
                // De esta forma además tod0 hereda de material design y lo predispuesto por Google.
                MyMessages(messages)
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>) {
    // La implementación de la columna de esta manera es muchísimo más óptima
    // Además incluye un scroll inteligente que solo pinta los elementos que deben aparecer,
    // elimina los que ya no aparecen y pinta los que sí.
    LazyColumn {  // Es más óptimo que Column porque solo pinta lo que se pueda a mostrar.
        items(messages) { message ->  // Se ejecuta por cada elemento de la lista inteligentemente.
            MyComponent(message)
        }
    }
}


// Para evitar superposición de imagen y texto en este caso
@Composable
fun MyComponent(message: MyMessage) {
    // Vamos a añadirle un modificador. Hay que ir concatenando cada modificación ya que es funcional.
    // Cada modificador realiza cambios sobre el elemento actual y lo devuelve modificado, devolviendo
    // un nuevo modifier. Al que le podemos seguir aplicando nuevos modificadores. Se ejecutan en orden.
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)) {
        MyImage()
        MyTexts(message)
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
fun MyTexts(message: MyMessage) {
    // Puesto así saldrían superpuestos
    /*MyText("Hola Jetpack Compose!")
    MyText("¿Preparado?")*/

    // De esta manera los tendríamos en filas y orden de primero a último de arriba a abajo
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            message.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.bodyMedium)
        // También hay modificadores para meter espaciado en anchura y/o altura
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
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
@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent() {
    // Puesto así se superponen también
    /*MyImage()
    MyTexts()*/

    // De esta manera no se superponen sino que van a columnas
    /*JetpackComposeTutorialTheme {
        MyComponent()
    }*/

    // Ahora vamos a columnear y tener scroll
    /*JetpackComposeTutorialTheme {

        val scrollState = rememberScrollState()  // Para que recuerde el estado del scroll

        Column(modifier = Modifier.verticalScroll(scrollState)) {  // Con un modificador añadiremos una barra de scroll
            MyMessages(messages)
        }*/

    // Ahora vamos a usar las columnas óptimas y tener el listado de mensajes
    JetpackComposeTutorialTheme {
        // De esta forma además tod0 hereda de material design y lo predispuesto por Google.
        MyMessages(messages)
    }
}
