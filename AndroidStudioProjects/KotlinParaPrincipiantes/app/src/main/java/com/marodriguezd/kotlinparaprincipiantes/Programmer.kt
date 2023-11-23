package com.marodriguezd.kotlinparaprincipiantes

/*
Las propiedades quedan ocultas por defecto en la clase y
debemos elegir si son variables o constantes para que se puedan o no modificar.
 */
class Programmer(val name: String,
                 var age: Int,
                 val languages: Array<Language>,
                 val friends: Array<Programmer>? = null) {  // friends puede ser nulo "?"
                        // Al darle nulo por defecto no es obligatorio instanciarlo en constructor.
    /*
    Sirve para designar diversos valores y se puedan escoger solo esos por ejemplo.
     */
    enum class Language {  // Nos aseguramos de que solo asignen estos valores al programador.
        KOTLIN,
        SWIFT,
        JAVA,
        JAVASCRIPT
    }

    fun code() {
        for (language in languages) {
            println("Estoy programndo en $language")
        }
    }

}