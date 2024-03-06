package com.marodriguezd.firebasetutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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

/**
 * SplashScreen muestra una pantalla de carga mientras determina la siguiente ruta de navegación
 * basada en el estado de autenticación del usuario.
 *
 * @param navController NavController para manejar la navegación.
 */
@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current  // No se puede crear dentro del LaunchedEffect.

    LaunchedEffect(key1 = true) {
        // delay(2000)  // Simula la carga de recursos durante 2 segundos.

        val (email, provider) = getUserData(context)
        val route = if (email != null && provider != null) {
            AppScreens.HomeActivity.createRoute(email, ProviderType.valueOf(provider))
        } else {
            AppScreens.AuthActivity.route
        }

        navController.navigate(route) {
                popUpTo(AppScreens.SplashScreen.route) { inclusive = true }
            }
        }

    // ContenidoSplash()  // Muestra el contenido de tu SplashScreen
}

/**
 * ContenidoSplash muestra el contenido de la SplashScreen, como el logo y el texto de bienvenida.
 */
@Composable
fun ContenidoSplash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logoso),
            contentDescription = "Logo de la aplicación.",
            Modifier.size(150.dp)//, 150.dp)
        )
        Text(
            "Bienvenid@s",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/**
 * SplashScreenPreview proporciona una vista previa de la SplashScreen para fines de desarrollo.
 */
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    ContenidoSplash()
}