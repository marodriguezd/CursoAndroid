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

                // Lección 1
                // variablesYConstantes()

                // Lección 2
                tiposDeDatos()
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

    /*
    Aquí vamos a hablar de tipos de datos (Data Types)
     */
    private fun tiposDeDatos(){

        // String

        val myString: String = "Hola Hackermen!"
        val myString2 = "Bienvenidos a Mouredev"
        val myString3 = myString + " " + myString2
        println(myString3)

        // Enteros (Byte, Short, Int, Long)

        val myInt: Int = 1  // Se suelen usar Integers
        val myInt2 = 2
        val myInt3 = myInt + myInt2
        println(myInt3)

        // Decimales (Float, Double)

        val myFloat: Float = 1.5f  // Se suelen usar Doubles
        val myDouble = 1.5
        val myDouble2 = 2.6
        val myDouble3 = 1  // En realidad este es Int
        val myDouble4 = myDouble + myDouble2 + myDouble3
        println(myDouble4)

        // Boolean (Bool)
        val myBool: Boolean = true
        val myBool2 = false
        // val myBool3 = myBool + myBool2  // No funciona obvio
        println(myBool == myBool2)
        println(myBool && myBool2)  // Es como un si ambos son true

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