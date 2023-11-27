package com.marodriguezd.kotlinintermedio

/*
No escribir nada al principio es igual que poner: public

 */
private class Visibility {

    var name: String? = null

    private fun sayMyName() {
        name?.let {  // Como un if pero para cuando sea no nulo o nulo
            println("Mi nombre es $it")  // it recoge el valor de name en caso no nulo
        } ?: run {
            println("No tengo nombre")
        }
    }
}

open class VisibilityTwo {  // El open es para que la clase sea extendible

    protected fun sayMyNameTwo() {

        val visibility = Visibility()
        visibility.name = "Brais"
    }
}

class VisibilityThree: VisibilityTwo() {

    internal val age: Int? = null  // Como darle a la variable un tipo local para solo uso módulo.

    fun sayMyNameThree() {

    }
}