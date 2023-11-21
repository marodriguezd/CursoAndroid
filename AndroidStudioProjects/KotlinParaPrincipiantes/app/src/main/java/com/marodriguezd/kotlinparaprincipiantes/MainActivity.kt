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
                // sentenciaWhen()

                // Lección 5
                // arrays()

                // Lección 6
                // maps()

                // Lección 7
                // loops()

                // Lección 8
                nullSafety()
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

    /*
    Aquí vamos a hablar de arrays o arreglos
     */
    private fun arrays() {

        val name = "Brais"
        val surname = "Moure"
        val company = "MoureDev"
        val age = "32"

        // Creación de un Array

        val myArray = arrayListOf<String>()

        // Añadir datos de uno en uno

        myArray.add(name)
        myArray.add(surname)
        myArray.add(company)
        myArray.add(age)

        println(myArray)

        // Añadir un conjunto de datos

        myArray.addAll(listOf("Hola", "Bienvenidos al tutorial"))

        println(myArray)

        // Acceso a datos

        val myCompany = myArray[2]

        println(myCompany)

        // Modificación de datos

        myArray[5] = "Suscríbete y activa la campana"

        println(myArray)

        // Eliminar datos

        myArray.removeAt(4)

        println(myArray)

        // Recorrer datos

        myArray.forEach {
            println(it)  // it es el valor que toma cada que accede a un dato.
        }

        // Otras operaciones

        println(myArray.count())  // Como el len de Python

        myArray.clear()  // Para vaciar el array

        println(myArray.count())

        myArray.first()  // Para acceder al primer elemento
        myArray.last()  // Para acceder al último elemento

        myArray.sort()  // Para ordenar, habiendo varios donde elegir
    }

    /*
    Aquí vamos a hablar de mapas, también llamados diccionarios
     */
    private fun maps() {

        // Sintaxis
        var myMap: Map<String, Int> = mapOf()  // Para inicializar el mapa vacío
        println(myMap)

        // Añadir elementos
        myMap = mapOf("Brais" to 1, "Pedro" to 2, "Sara" to 5)  // como en Python con {"Clave": valor}
        // Esto nos crea un mapa que no es mutable, no se puede editar/añadir más.
        myMap = mutableMapOf("Brais" to 1, "Pedro" to 2, "Sara" to 5)
        // De esta manera ya sí que podremos añadir más abajo cosas
        println(myMap)

        // Añadir un solo valor
        myMap["Ana"] = 7  // Forma 1 de añadir un valor
        myMap.put("María", 8)  // Forma 2 de añadir un valor
        println(myMap)

        // Actualización de un dato
        myMap.put("Brais", 3)  // Modifica el valor de la clave Brais
        // con put se añade tanto como se actualiza
        println(myMap)

        myMap.put("Marcos", 3)  // Los valores se pueden repetir sin problema alguno.
        println(myMap)

        // Acceso a un dato
        println(myMap["Brais"])

        // Eliminar un dato
        myMap.remove("Brais")
        println(myMap)
    }

    /*
    Aquí vamos a hablar de loops, también llamados bucles
     */
    private fun loops() {

        // Bucles

        val myArray = listOf("Hola", "Bienvenidos al tutorial", "Suscríbete")
        val myMap = mutableMapOf("Brais" to 1, "Pedro" to 2, "Sara" to 5)

        // For

        for (myString in myArray) {  // Lo primero es iterador y lo segundo la lista
            println(myString)
        }

        for (myElement in myMap) {  // Iterador y Map
            println("${myElement.key}-${myElement.value}")  // Mostrar clave-valor
        }

        for (x in 0..10) {  // Iterar de 0 a 10 inclusive
            println(x)
        }

        for (x in 0 until 10) {  // Iterar de 0 a 10, siendo más como Java
            println(x)
        }

        for (x in 0 .. 10 step 2) {  // Iterar de 0 a 10 yendo de par en par
            println(x)
        }


        for (x in 10 downTo 0 step 3) {  // Iterar de 10 a 0 yendo de 3 en 3
            println(x)
        }

        val myNumericArray = (0..20)  // Directo de 0 a 20 súper easy
        for (myNum in myNumericArray) {
            println(myNum)
        }

        // While

        var x = 0

        while (x < 10) {
            println(x)
            // x++  // Funciona igual que en Java
            x += 2  // Y obvio como en Python
        }
    }

    /*
    Aquí vamos a hablar de seguridad contra nulos ( Null Safety)
     */
    private fun nullSafety() {

        var myString = "MoureDev"
        // myString = null  // Esto daría un error de compilación
        println(myString)

        // Variable null safety
        var mySafetyString: String? = "MoureDev null safety"
        mySafetyString = null
        println(mySafetyString)

        mySafetyString = "Suscríbete!"
        // println(mySafetyString)

        /*
        // Este bloque no funciona a día de hoy aparentemente
        println(mySafetyString!!)  // !! Es para sí o sí solo imprima si no es nulo

        if (mySafetyString != null) {
            println(mySafetyString!!)  // !! Es para sí o sí solo imprima si no es nulo
        } else {
            println(mySafetyString!!)
         */

        // Safe call

        println(mySafetyString?.length)  // Si es null no ejecuta la instrucción y saca null

        mySafetyString?.let {  // Solo ejecuta ese bloque de código si no es null
            println(it)  // it == mySafetyString!!  // Que fuerza que no sea nulo para ejecutar
        } ?: run {  // En caso de nulo ejecuta esto
            println(mySafetyString)
        }

        /*
        De esta forma siempre estamos obligados a controlar los nulos con nulables
         */
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