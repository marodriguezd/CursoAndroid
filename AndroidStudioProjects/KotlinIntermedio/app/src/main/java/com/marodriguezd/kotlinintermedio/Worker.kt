package com.marodriguezd.kotlinintermedio

/*
Se recomienda trabajar con propiedades inmutables.
Con esto hemos definido un objeto de tipo trabajador con 3 propiedades necesarias para conformarse.
Normalmente esto se usa para almacenar datos
 */
data class Worker(val name: String = "", val age: Int = 0, val work: String = "") {

    var lastWork: String = ""  // Así obligamos a rellenarle el dato
}
