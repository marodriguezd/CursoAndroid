package com.marodriguezd.jetpackcompenavigation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.marodriguezd.jetpackcompenavigation.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")  // Sin esto daba error.
@Composable
fun SecondScreen(navController: NavController, text: String?) {
    Scaffold(topBar = {
        TopAppBar(title = {
            // Vamos a añadir una flecha para volver atrás
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.width(8.dp))  // No funciona
            Text(text = "      SecondScreen")  // No es la mejor opción pero va.
        })
    }) {  // Elemento gráfico para estructurar los elementos más típicos de una pantalla.
        SecondBodyContent(navController, text)
    }
}

@Composable
fun SecondBodyContent(navController: NavController, text: String?) {
    // Vamos a crear una columan con texto y botón.
    Column(  // Esto está modificado así para que se sitúe en el centro de la pantalla.
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("He navegado")
        text?.let {  // Esto es para comprobar que no sea nulo, y en caso de ser asi seguir con el bloque
            Text(it)
        }
        Button(onClick = {
            // navController.navigate(route = AppScreens.FirstScreen.route)
            navController.popBackStack()  // Esto es mejor que lo de arriba, ya que directamente devuelve a la anterior.
        }) {
            Text("Volver atrás")
        }
    }
}
