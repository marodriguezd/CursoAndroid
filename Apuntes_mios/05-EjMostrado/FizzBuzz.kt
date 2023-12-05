// Ejecutar en https://play.kotlinlang.org
fun main() {
    for (index in 1..100) {
        val divisibleByThree = index % 3 == 0
        val divisibleByFive = index % 5 == 0

        if (divisibleByThree && divisibleByFive) {
            println("fizzbuzz")
        } else if (divisibleByThree) {
            println("fizz")
        } else if (divisibleByFive) {
            println("buzz")
        } else {
            println("$index")
        }
    }
}