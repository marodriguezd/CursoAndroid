package com.marodriguezd.solidkotlin.solid

/**
 * Open-Closed Principle
 */

// Para cumplir el principio abierto/cerrado sería:

interface Polygon {  // Define función común a todos los polígonos
    fun area(): Double
}

data class Triangle(val lenght: Double, val height: Double): Polygon {
    override fun area(): Double {
        return (lenght * height) / 2
    }
}

data class Circle(val radius: Double): Polygon {
    override fun area(): Double {
        return Math.PI * (radius * radius)
    }
}

data class Rectangle(val lenght: Double, val height: Double): Polygon {
    override fun area(): Double {
        return lenght * height
    }
}

class Area {
    fun calculateArea(polygon: Polygon): Double? {
        return polygon.area()
    }
}

// En este ejemplo si queremos añadir un nuevo tipo de polígono tendríamos que editar la función.
// No está cerrada a modificación, ya que mientras más polígonos más modificaciones.
/*
data class Triangle(val lenght: Double, val height: Double)

data class Circle(val radius: Double)

class Area {
    fun calculateArea(polygon: Any): Double? {
        return when (polygon) {
            is Triangle -> {
                (polygon.lenght * polygon.height) / 2
            }
            is Circle ->  {
                Math.PI * (polygon.radius * polygon.radius)
            }
            else -> {
                null
            }
        }
    }
}*/
