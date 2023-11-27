package com.marodriguezd.kotlinintermedio

/*
A diferencia de las clases abstractas aquí sí que se pueden tener valores y comportamientos.
No puede contener un constructor tampoco.
 */
interface Game {

    val game: String

    fun play()  // No hace falta definir que sea abstracto, lo son por defecto.

    fun stream() {  // Permite añadir comportamiento.
        println("Estoy haciendo stream de mi juego $game")
    }

}