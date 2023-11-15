package com.marodriguezd.kotlinparaprincipiantes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.marodriguezd.kotlinparaprincipiantes.ui.theme.KotlinParaPrincipiantesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinParaPrincipiantesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Hackermen")  // Android
                }


                variablesYConstantes()
            }
        }
    }

    /*
    Aquí vamos a hablar de variables y constantes
     */
    private fun variablesYConstantes(){
        // Variables

        var myFirstVariable = "Hello Hackermen!"
        var myFirstNumber = 1

        println(myFirstVariable)

        myFirstVariable = "Bienvenidos a Mouredev"

        println(myFirstVariable)

        // No podemos asignar un tipo Int a una variable de tipo String
        // myFirstVariable = 1

        var mySecondVariable = "Suscríbete!"

        println(mySecondVariable)

        mySecondVariable = myFirstVariable

        println(mySecondVariable)

        myFirstVariable = "¿Ya te has suscrito?"

        println(myFirstVariable)

        // Constantes

        val myFirstConstant = "¿Te ha gustado el tutorial?"

        println(myFirstConstant)

        // Una constante no puede modificar su valor
        // myFirstConstant = "Si te ha gustado, dale a LIKE"

        val mySecondConstant = myFirstVariable

        println(mySecondConstant)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinParaPrincipiantesTheme {
        Greeting("Hackermen")  // Android
    }
}