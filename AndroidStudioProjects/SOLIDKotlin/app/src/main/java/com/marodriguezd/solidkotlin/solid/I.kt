package com.marodriguezd.solidkotlin.solid

/**
 * Interface Segregation Principle
 */

// Así sería de la manera correcta.
// Crear tantas interfaces como funcionalidades precisen los objetos. Agrupando las funcionalidades de la entidad a representar.
interface Vehicle {
    fun move()
}

// Y si queremos definir vehículos que tengas las propiedades de volar o nadar sería
// crear interfaces propias con esas funciones.
interface FlyingVehicle {
    fun fly()
}
interface WaterVehicle {
    fun swim()
}


// De esta forma un coche solo implementaría vehículo
class Car: Vehicle {
    override fun move() {
        TODO("Not yet implemented")
    }
}

// Un avión implementaría vehículo y volador
class Plane: Vehicle, FlyingVehicle {
    override fun move() {
        TODO("Not yet implemented")
    }

    override fun fly() {
        TODO("Not yet implemented")
    }
}

// Y un barco vehículo y acuático
class Boat: Vehicle, WaterVehicle {
    override fun move() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }
}

// Esto estaría mal ya que por ejemplo coche y avión solo tienen en común el moverse. La interfaz estaría mal diseñada.
/*
interface Vehicle {
    fun move()
    fun fly()
    fun swim()
}

class Car: Vehicle {
    override fun move() {
        TODO("Not yet implemented")
    }

    override fun fly() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }

}

class Plane: Vehicle {
    override fun move() {
        TODO("Not yet implemented")
    }

    override fun fly() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }

}*/
