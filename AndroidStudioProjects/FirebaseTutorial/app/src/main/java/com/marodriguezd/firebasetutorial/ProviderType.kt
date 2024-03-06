package com.marodriguezd.firebasetutorial

/**
 * Define los tipos de proveedores de autenticación soportados en la aplicación.
 */
enum class ProviderType {
    /**
     * Representa la autenticación utilizando correo electrónico y contraseña.
     */
    BASIC,

    /**
     * Representa la autenticación a través del proveedor Google.
     */
    GOOGLE,

    /**
     * Representa la autenticación mediante el proveedor Facebook.
     */
    FACEBOOK,

    // Puedes añadir más proveedores de autenticación aquí conforme sea necesario,
    // como Twitter, Github, etc.
}
