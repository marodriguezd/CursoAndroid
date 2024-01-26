package com.marodriguezd.jetpackcompenavigation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.marodriguezd.jetpackcompenavigation.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")  // Sin esto daba error.
@Composable
fun FirstScreen(navController: NavController) {
    // Al usar el Scaffold opdemos añadir el parámetro topBar
    Scaffold(topBar = {
        TopAppBar(title = { 
            Text(text = "FirstScreen")
        })
    }) {  // Elemento gráfico para estructurar los elementos más típicos de una pantalla.
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController) {
    // Vamos a crear una columan con texto y botón.
    Column(  // Esto está modificado así para que se sitúe en el centro de la pantalla.
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hola navegación")
        Button(onClick = {
            navController.navigate(route = AppScreens.SecondScreen.route)
        }) {
            Text("Navega")
        }
    }
}
