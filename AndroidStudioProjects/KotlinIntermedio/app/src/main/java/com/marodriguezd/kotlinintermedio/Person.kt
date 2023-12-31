package com.marodriguezd.kotlinintermedio

/*
Por defecto todas las clases y funciones son finales y no se pueden sobreescribir
 */
open class Person(name: String, age: Int) : Work(), Game {  // Open hace que pueda ser heredable
    // Cualquier clase tiene una superclase común "Any"

    open fun work() {
        println("Esta persona está trabajando")
    }

    override fun goToWork() {
        println("Esta persona va al trabajo")
    }

    // Game Interface

    override val game: String = "Among Us"

    override fun play() {
        println("Esta persona está jugando a $game")
    }
}