package com.marodriguezd.solidkotlin.solid

/**
 * Liskov Substitution Principle
 */

// Si no se cumple el principio de sustitución de Liskov tampoco lo hace el abierto/cerrado.
// En vez de clase abstracta usar abierta.
open class Creature {
    fun move() {
        println("Move")
    }

    fun swim() {
        println("Swim")
    }
}

class Human : Creature() {
}

class Bird : Creature() {

}

class Fish : Creature() {

}

fun main() {
    val human = Human()
    human.move()

    val bird = Fish()
    human.move()

    val creature = Creature()  // Esta es la clase base o súper clase, pudiendo reemplazarse por su sub.
    creature.move()
    creature.swim()

    val creature2 = Bird()  // Esto demuestra que se cumple el principio de sustitución de Liskov y abierto o cerrado.
    creature2.move()
    creature2.swim()

}

// De esta manera no se cumpliría el principio, ya que un humano no puede volar por ejemplo.
/*
abstract class Creature {
    fun move() {
        println("Move")
    }

    fun fly() {
        println("Fly")
    }

    fun swim() {
        println("Swim")
    }
}

class Human : Creature() {
}

class Bird : Creature() {

}

class Fish : Creature() {

}

fun main() {
    val human = Human()
    human.move()
    human.fly()

    val bird = Fish()
    human.move()
    human.fly()
}*/
