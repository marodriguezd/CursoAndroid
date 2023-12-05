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
import java.util.Date
import kotlin.concurrent.thread

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
                // typeAliases()

                // Destructuring declarations
                // destructuringDeclarations()

                // Extensions
                // extensions()

                // Lambdas
                lambdas()

            }
        }
    }

    // Lección 1 Kotlin Intermedio: Enum Classes

    enum class Direction(val dir: Int) {

        NORTH(1), SOUTH(-1), EAST(1), WEST(-1);

        fun description(): String {

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
        val myInnerClass = NestedAnInnerClass().MyInnerClass()  // Intanciamos clase padre e interna
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

    // Lección 8 Kotlin Intermedio: Destructuring declarations
    private fun destructuringDeclarations() {

        // Si no queremos el valor de en medio podemos poner un _ para usar la desestructuración
        // de manera más eficiente.
        val (name, _, work) = Worker("Brais Moure", 34, "Programador")
        // val (name, age, work) = Worker("Brais Moure", 34, "Programador")
        println("$name, $work")

        val mouredev = Worker("Brais Moure", 34, "Programador")
        println(mouredev.component1())

        val (braisName, braisAge) = myWorker()  // Podemos quedarnos solo con las 2 primeras por ej.
        println("$braisName, $braisAge")

        val myMap = mapOf(1 to "Brais", 2 to "Ana", 3 to "Sara")
        for ((id, name) in myMap) {
            println("$id, $name")
        }
    }

    private fun myWorker(): Worker {
        return Worker("Brais Moure", 34, "Programador")
    }

    // Lección 9 Kotlin Intermedio: Extensions
    private fun extensions() {

        val myDate = Date()
        println(myDate.customFormat())
        println(myDate.formatSize)

        var myDateNullable: Date? = null
        println(myDateNullable.customFormat())
        println(myDateNullable.formatSize)
    }

    // Lección 10: Kotlin Intermedio: Lambdas
    private fun lambdas() {

        val myIntList = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val myFilterIntList = myIntList.filter { myInt ->

            println(myInt)
            if (myInt == 1) {
                return@filter true
            }

            myInt > 5
        }
        /*val myFilterIntList = myIntList.filter {
            it > 5
        }*/
        println(myFilterIntList)

        val mySumFun = fun(x: Int, y: Int): Int = x + y // Ver. resumida si es simple el return.
        /*val mySumFun = fun (x: Int, y: Int): Int {
           return x + y
        }*/
        val myMultFun = fun(x: Int, y: Int): Int = x * y

        myAsyncFun("MoureDev") {
            println(it)
        }

        println(myOperateFun(5, 10, mySumFun))
        println(myOperateFun(5, 10, myMultFun))
        println(myOperateFun(5, 10) { x, y -> x - y })  // Return implícito

    }

    private fun myOperateFun(x: Int, y: Int, myFun: (Int, Int) -> Int): Int {
        return myFun(x, y)
    }

    private fun myAsyncFun(name: String, hello: (String) -> Unit) {  // Unit es como void de Java.
        val myNewString = "Hello $name!"

        thread {
            Thread.sleep(5000)
            hello(myNewString)
        }

        thread {
            Thread.sleep(1000)
            hello(myNewString)
        }

        thread {
            Thread.sleep(7000)
            hello(myNewString)
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
    KotlinIntermedioTheme {
        Greeting("Hackermen")
    }
}