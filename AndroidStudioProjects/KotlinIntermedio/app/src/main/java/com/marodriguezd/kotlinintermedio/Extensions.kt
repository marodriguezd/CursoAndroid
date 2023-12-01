package com.marodriguezd.kotlinintermedio

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date?.customFormat() : String? {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ", Locale.getDefault())
    if (this != null) {
        return formatter.format(this) // Este this hace referencia a la clase base.
    }
    return null
}

val Date?.formatSize : Int
    get() = this.customFormat()?.length ?: 0
