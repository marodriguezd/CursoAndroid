package com.marodriguezd.solidkotlin.solid

/**
 * Dependency Inversion Principle
 */

// Con esto nos aseguraríamos que de tener que cambiar la interface tendría que cambiar
// en todos sus proveedores. Además de permitir el uso de todos los proveedores que
// la hereden de forma segura.
interface AuthProvider {
    fun login(user: String, password: String)
}

// Esto permite que cada proveedor evolucione como quiera pero cumpliendo siempre la
// abstracción de la interfaz.

class GoogleAuth(): AuthProvider {
    override fun login(user: String, password: String) {

    }
}

class FacebookAuth(): AuthProvider {
    override fun login(user: String, password: String) {

    }
}

// La implementación del login obliga a que sea igual en ambos casos.
class UserAuth() {
    fun auth(user: String, password: String){
        GoogleAuth().login(user, password)
        FacebookAuth().login(user, password)
    }
}

// Hecho de esta manera tendría el problema en que si algún día cambia el como
// recibe los parámetros, daría problemas. Por eso debemos depender de abstracciones.
/*
class GoogleAuth() {
    fun login(user: String, password: String){}
}

class FacebookAuth() {
    fun login(user: String, password: String){}
}

class UserAuth() {
    fun auth(user: String, password: String){
        GoogleAuth().login(user, password)
        FacebookAuth().login(user, password)
    }
}*/
