package com.marodriguezd.solidkotlin.solid

/**
 * Single Responsability Principle
 */

// Aquí tendríamos la función corregida divida en 2 de solo 1 responsabilidad.
data class User(val id: Int, val name: String)

class UserDB {
    fun user(id: Int): User {
        // Búsqueda en base de datos
        return User(0, "")
    }
}

// Esto tendría 2 responsabilidades así que estaría mal.
/*
data class User(val id: Int, val name: String) {
    fun user(id: Int): User {
        // Búsqueda en base de datos
        return User(0, "")
    }
}*/
