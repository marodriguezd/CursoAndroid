package com.marodriguezd.firebasetutorial

import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


/**
 * Pantalla de autenticación que permite a los usuarios registrarse o iniciar sesión con email y contraseña,
 * así como iniciar sesión con Google.
 *
 * @param onNavigateToHome Callback que se ejecuta para navegar a la pantalla de inicio después
 */
@Composable
fun AuthActivity(onNavigateToHome: (String, ProviderType) -> Unit) {
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {  // *
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    saveUserData(context, email, ProviderType.BASIC.name)  // Pasa el contexto aquí
                                    onNavigateToHome(email, ProviderType.BASIC)
                                } else {
                                    errorMessage = task.exception?.message
                                        ?: "Se ha producido un error autenticando al usuario"
                                    showDialog = true
                                }
                            }
                    }
                }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1967D2)),
                modifier = Modifier.weight(1f)
            ) {
                Text("Registrar")
            }

            Button(
                onClick = {  // *
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    // Aquí asumimos que el proveedor es "BASIC" por ahora
                                    saveUserData(context, email, ProviderType.BASIC.name)  // Pasa el contexto aquí
                                    onNavigateToHome(email, ProviderType.BASIC)
                                } else {
                                    errorMessage = task.exception?.message
                                        ?: "Se ha producido un error autenticando al usuario"
                                    showDialog = true
                                }
                            }
                    }
                }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B3A57)),
                modifier = Modifier.weight(1f)
            ) {
                Text("Acceder")
            }
        }

        if (showDialog) {
            AlertDialog(onDismissRequest = { showDialog = false },
                title = { Text("Error") },
                text = { Text(errorMessage) },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Aceptar")
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        val googleSignInOptions = remember {
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        }

        val googleSignInClient = remember {
            GoogleSignIn.getClient(context, googleSignInOptions)
        }

        val googleSignInLauncher = rememberLauncherForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->  // *
            if (result.resultCode == android.app.Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    firebaseAuthWithGoogle(account.idToken!!, context, onNavigateToHome)
                } catch (e: ApiException) {
                    // Manejar excepción, por ejemplo, mostrando un diálogo de error
                }
            }
        }


        Button(
            onClick = {
                googleSignInClient.signOut()  // Para desloguear 100% Google
                val signInIntent = googleSignInClient.signInIntent
                googleSignInLauncher.launch(signInIntent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFf2f2f2),contentColor = Color.Unspecified),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google sign-in",
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Google", color = Color.Black)
        }
    }
}

fun firebaseAuthWithGoogle(idToken: String, context: Context, onNavigateToHome: (String, ProviderType) -> Unit) {
    val credential = GoogleAuthProvider.getCredential(idToken, null)
    FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val user = task.result?.user
            if (user != null) {
                // Guardar datos del usuario y navegar a Home
                saveUserData(context, user.email!!, ProviderType.GOOGLE.name)
                onNavigateToHome(user.email!!, ProviderType.GOOGLE)
            }
        } else {
            // Manejar fallo en el inicio de sesión, por ejemplo, mostrando un diálogo de error
        }
    }
}