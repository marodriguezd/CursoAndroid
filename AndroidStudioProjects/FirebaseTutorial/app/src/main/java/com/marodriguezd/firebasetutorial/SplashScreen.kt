package com.marodriguezd.firebasetutorial

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
import androidx.navigation.NavController
import com.marodriguezd.firebasetutorial.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // LaunchedEffect ejecutará el bloque de código una sola vez si el valor de key1 no cambia.
    // Si el valor de key1 cambia, el efecto se reinicia y el bloque de código se ejecuta de nuevo.
    // LaunchedEffect se usa para lanzar efectos secundarios, como tareas asíncronas, dentro del alcance de una corrutina,
    // y es compatible con la arquitectura de composables de Jetpack Compose.
    LaunchedEffect(key1 = true) {
        delay(5000)
        // Una vez arrancada la app no queremos volver al Splash
        navController.popBackStack()  // Limpia el historial de navegación.
        navController.navigate(AppScreens.MainScreen.route)
        // Ahora la última/única pantalla que existe es la main.
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
        Image(
            painter = painterResource(id = R.drawable.logoso),
            contentDescription = "Logo de un pedazo de oso amante del café friqui de las arcades.",
            Modifier.size(150.dp, 150.dp)
        )
        Text(
            "Bienvenid@s",
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