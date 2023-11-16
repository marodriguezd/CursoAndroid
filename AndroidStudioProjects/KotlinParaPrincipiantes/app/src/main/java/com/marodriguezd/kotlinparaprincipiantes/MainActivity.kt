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
                // tiposDeDatos()

                // Lección 3
                // sentenciaIf()

                // Lección 4
                sentenciaWhen()
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

    /*
    Aquí vamos a hablar de la sentencia if
     */
    private fun sentenciaIf(){

        val myNumber = 70

        // Operadores condicionales
        // > mayor que
        // < menor que
        // >= mayor o igual que
        // <= menor o igual que
        // == igualdad
        // != desigualdad

        // Operadores lógicos
        // && operador "y"
        // || operador "o"
        // !  operador "no"

        if (!(myNumber > 10 && myNumber <= 5) || myNumber == 53) {
            // Sentencia if
            println("$myNumber es menor o igual que 10 y mayor que 5 o es igual a 53")

        } else if(myNumber == 60) {
            // Sentencia else if
            println("$myNumber es igual a 60")

        } else if((myNumber == 70)) {
            // Sentencia else if
            println("$myNumber no es igual a 70")

        } else {
            // Sentencia else
            println("$myNumber es mayor que 10 o menor o igual que 5 y no es igual a 53")
        }
    }

    /*
    Aquí vamos a hablar de la sentencia when (switch)
     */
    private fun sentenciaWhen() {

        // When con String
        val country = "Italia"

        when (country) {
            "España", "México", "Perú", "Colombia", "Argentina" -> {
                println("El idioma es Español")
            } "EEUU" -> {
                println("El idioma es Inglés")
            } "Francia" -> {
                println("El idioma es Francés")
            } else -> {
                println("No conocemos el idioma")
            }
        }

        // When con Int
        val age = 10

        when (age) {
            0, 1, 2 -> {
                println("Eres un bebé")
            } in 3..10 -> {  // Para poner un rango de números
                println("Eres un niño")
            } in 11..17 -> {
                println("Eres un adolescente")
            } in 18..69 -> {
                println("Eres adulto")
            } in 70..99 -> {
                println("Eres anciano")
            } else -> {
                println("😱")
            }
        }
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