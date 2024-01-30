package com.marodriguezd.jetpackcomposesplashscreen

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.marodriguezd.jetpackcomposesplashscreen.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    // key1 es algo relacionado a repintado automático.
    LaunchedEffect(key1 = true) {  // Permite crear una corrutina. Referencia a una tarea asíncrona. Además de dar soporte a elementos composables.
        delay(5000)
        // No nos interesa poder volver a la pantalla de Splash una vez arrancada la app
        navController.popBackStack()  // Con esto limpiamos la pantalla de navegación y la main screen será la única pantalla disponible.
        navController.navigate(AppScreens.MainScreen.route)
    }
    Splash()
}

@Composable
fun Splash() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logoso),
            contentDescription = "Logo de un pedazo de oso amante del café friqui de las arcades.",
            Modifier.size(150.dp, 150.dp))
        Text("Bienvenid@s",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash()
}