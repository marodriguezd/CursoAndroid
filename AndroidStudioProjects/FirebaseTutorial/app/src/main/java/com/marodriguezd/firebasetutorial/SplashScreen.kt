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
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current  // Obtiene el contexto actual de un composable

    // LaunchedEffect ejecutará un bloque de código una sola vez si el valor de key1 no cambia
    LaunchedEffect(key1 = true) {
        // delay(2000)  // Mock de carga de recursos durante 2 segundos

        // Ahora decide a dónde navegar basado en si el usuario está autenticado
        val (email, provider) = getUserData(context)
        if (email != null && provider != null) {
            // Si hay datos de usuario, asumimos que el usuario está "autenticado"
            // y navegamos a HomeActivity
            val route = AppScreens.HomeActivity.createRoute(email, ProviderType.valueOf(provider))
            navController.navigate(route) {
                popUpTo(AppScreens.SplashScreen.route) { inclusive = true }
            }
        } else {
            // No hay datos de usuario, navegar a la pantalla de autenticación
            navController.navigate(AppScreens.AuthActivity.route) {
                popUpTo(AppScreens.SplashScreen.route) { inclusive = true }
            }
        }
    }

    // Splash()  // Muestra el contenido de tu SplashScreen
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