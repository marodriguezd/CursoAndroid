package com.marodriguezd.kotlinintermedio

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
import com.marodriguezd.kotlinintermedio.ui.theme.KotlinIntermedioTheme

// Con el type alias podemos crear nuestro propio "tipo".
// También se puede usar para representar funciones.
// Clases anidadas cumplen esta condición.
typealias MyMapList = MutableMap<Int, ArrayList<String>>  // Con esto facilitamos la creación datil.
typealias MyFun = (Int, String, MyMapList) -> Boolean
typealias MyNestedClass = NestedAnInnerClass.MyNestedClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinIntermedioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Hackermen")
                }

                // Enum Classes
                // enumClasses()

                // Nested and Inner Classes
                // nestedAndInnerClasses()

                // Class Inheritance
                // classInheritance()

                // Interfaces
                // interfaces()

                // Visibility Modifiers
                // visibilityModifiers()

                // Data Classes
                // dataClasses()

                // Type aliases
                typeAliases()
            }
        }
    }

    // Lección 1 Kotlin Intermedio: Enum Classes

    enum class Direction(val dir: Int) {

        NORTH(1), SOUTH(-1), EAST(1), WEST(-1);

        fun description() : String {

            return when (this) {  // Mejor que if-elseif-else
                NORTH -> "La dirección es NORTE"
                SOUTH -> "La dirección es SUR"
                EAST -> "La dirección es ESTE"
                WEST -> "La dirección es OESTE"
            }
        }
    }

    private fun enumClasses() {

        // Asignación de valores
        var userDirection: Direction? = null
        println("Dirección: $userDirection")

        userDirection = Direction.NORTH
        println("Dirección: $userDirection")

        userDirection = Direction.WEST
        println("Dirección: $userDirection")

        // Propiedades por defecto
        println("Propiedad name: ${userDirection.name}")
        println("Propiedad ordinal: ${userDirection.ordinal}")

        // Funciones
        println(userDirection.description())

        // Inicialización
        println(userDirection.dir)
    }

    // Lección 2 Kotlin Intermedio: Nested and Inner Classes
    private fun nestedAndInnerClasses() {

        // Clase anidada (nested)
        val myNestedClass = MyNestedClass()  // Esto instancia la clase anidada
        // val myNestedClass = NestedAnInnerClass.MyNestedClass()  // Esto instancia la clase anidada
        val sum = myNestedClass.sum(10, 5)
        println("El resultado de la suma es $sum")

        // Clase interna (inner)
        val myInnerClass = MyNestedClass()  // Intanciamos clase padre e interna
        // val myInnerClass = NestedAnInnerClass().MyInnerClass()  // Intanciamos clase padre e interna
        val sumTwo = myInnerClass.sumTwo(10)
        println("El resultado de sumar dos es $sumTwo")
    }

    // Lección 3 Kotlin Intermedio: Class Inheritance
    private fun classInheritance() {

        val person = Person("Sara", 40)

        val programmer = Programmer("Brais", 33, "Kotlin")
        programmer.work()
        programmer.sayLanguage()
        programmer.goToWork()
        programmer.drive()

        val designer = Designer("Juan", 30)
        designer.work()
        designer.goToWork()
    }

    // Lección 4 Kotlin Intermedio: Interfaces
    private fun interfaces() {

        // No se puede instancias solo la interfaz, debe venir heredada en una clase.
        val gamer = Person("Brais", 33)
        gamer.play()
        gamer.stream()
    }

    // Lección 5 Kotlin Intermedio: Visibility Modifiers
    private fun visibilityModifiers() {

        /*val visibility = Visibility()
        visibility.name = "Brais"
        visibility.sayMyName()*/

        val visibilityTwo = VisibilityTwo()
    }

    // Lección 6 Kotlin Intermedio: Data Classes
    private fun dataClasses() {

        val brais = Worker("Brais Moure", 33, "Programador")
        brais.lastWork = "Músico"

        val sara = Worker()

        val mouredev = Worker("Brais Moure", 33, "Programador")
        brais.lastWork = "Músico"

        // equals & hashCode
        if (brais.equals(sara)) {
            println("Son iguales")
        } else {
            println("No son iguales")
        }

        if (brais == mouredev) {
            println("Son iguales")
        } else {
            println("No son iguales")
        }

        // toString
        println(brais.toString())

        // copy
        val brais2 = brais.copy(age = 34)
        println(brais.toString())
        println(brais2.toString())

        // componentN
        val (name, age) = mouredev
        println(name)
        println(age)
    }

    // Lección 7 Kotlin Intermedio: Type aliases

    private var myMap: MyMapList = mutableMapOf()
    // private var myMap: MutableMap<Int, ArrayList<String>> = mutableMapOf()

    private fun typeAliases() {

        var myNewMap: MyMapList = mutableMapOf()
        // var myNewMap: MutableMap<Int, ArrayList<String>> = mutableMapOf()
        myNewMap[1] = arrayListOf("Brais", "Moure")
        myNewMap[2] = arrayListOf("MoureDev", "by Brais Moure")

        myMap = myNewMap
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
    KotlinIntermedioTheme {
        Greeting("Hackermen")
    }
}