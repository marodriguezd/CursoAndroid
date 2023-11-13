# KOTLIN: Curso ANDROID desde CERO para PRINCIPIANTES

Aquí está el resumen traducido al español en formato de puntos:

# PARTE 1

* Presenta una visión general del tutorial, que busca enseñar a principiantes a crear aplicaciones Android con Kotlin. 

* Cubre las características básicas de Android Studio y presenta los fundamentos de la programación en Kotlin.

* Introduce el sitio web de Android Developers como recurso con tutoriales, versiones de Android y herramientas.  

* Concluye con una demostración de cómo iniciar un nuevo proyecto en Android Studio.

* Aprendemos a crear un proyecto Android desde cero en Android Studio, eligiendo la plataforma, plantilla pre diseñada, nombre de la app, nombre del paquete y lenguaje de programación.

* Exploramos el entorno de Android Studio, personalizamos la fuente y esquema de color y revisamos las opciones principales de la barra de herramientas.

* Creamos un dispositivo virtual nuevo y ejecutamos nuestra app para verificar que funciona correctamente. 

* Esta sección proporciona una visión integral de los pasos iniciales para desarrollar una app Android con Kotlin para principiantes.

* Cubre la estructura básica de un proyecto de Android Studio, incluyendo la jerarquía de archivos con el código, diseños y recursos.

* Explica cómo usar Android Studio para editar y ejecutar un proyecto, modificar propiedades de la app y depurar el código.

* Profundiza en distintas opciones disponibles en el editor y la consola, como abrir y cerrar archivos, inspeccionar valores y detectar errores.

* Discute los fundamentos de la programación de apps Android, comenzando con la elección entre Java y Kotlin. 

* Se enfoca en Kotlin, un lenguaje más moderno que podría convertirse en el estándar para desarrollo de apps.

* Presenta Android Studio como herramienta para desarrollo de apps. 

* Cubre la creación de una nueva app con Kotlin en Android Studio, con un código "Hola Mundo" simple. 

* Introduce el concepto de comentarios para anotar el código y hacerlo más legible.

* Discute el concepto de variables como parte fundamental para almacenar y manipular datos.

* Enseña cómo crear una variable en Kotlin, siguiendo las convenciones de nomenclatura camel case.

* Explica cómo asignar un valor a la variable e imprimirlo en la consola de salida.

* Cubre cómo modificar el valor de una variable y da un ejemplo de cómo ejecutar el código con el emulador de Android Studio.

* Explica que las variables pueden contener diferentes tipos de datos, como cadenas y números, pero su tipo no puede cambiarse una vez definido.

* Demuestra cómo crear nuevas variables, actualizar sus valores y asignar una variable a otra. 

* Introduce el concepto de constantes.

* Presenta las constantes en Kotlin y explica la diferencia con las variables: las constantes no se pueden cambiar después de asignarles un valor.

* Discute la importancia de los tipos de datos en programación y cómo restringen los valores y operaciones.

* Crea una nueva función "tipos de datos" para introducir los tipos de datos en Kotlin.

* Introduce los tipos de datos en Kotlin, comenzando con el tipo cadena. 

* Explica que los tipos de datos definen el tipo de valor para variables o constantes.

* Los tipos básicos en Kotlin son cadenas, enteros, decimales y booleanos.

* Demuestra cómo crear una constante tipo cadena y concatenar cadenas con el signo más. 

* Explica la inferencia de tipos de Kotlin, donde deduce el tipo según el valor asignado.

* Muestra el uso de println para imprimir la cadena concatenada y comenta el código para ejecutar solo la sección actual.

* Explica que hay cuatro tipos de enteros en Kotlin: byte, short, int y long, que difieren en la longitud del número que pueden representar.

* Recomienda usar el tipo que mejor se ajuste al rango posible y que suele usarse int y occasionalmente long. 

* Demuestra cómo crear tipos decimales float y double y realizar operaciones matemáticas básicas.

* Nota que por defecto, un número sin punto decimal es int y con punto decimal es double.

* Enfatiza la importancia de entender los tipos de datos en Kotlin. Explica cuatro tipos básicos: enteros, doubles, cadenas y booleanos.

* Muestra cómo crear variables de cada tipo y realizar operaciones. 

* Los booleanos son particularmente importantes para evaluar condiciones, e introduce las sentencias If-Else para ejecutar código según si una condición es verdadera o falsa.

* Da ejemplos para ilustrar sentencias If-Else en Kotlin.

* Introduce una nueva función "sentencia" para evaluar condiciones con el operador condicional.

* Crea la función "sentencia if" para demostrar cómo evaluar la condición si una variable es menor a 10.

* Explica varios operadores condicionales como mayor que, menor que, mayor o igual, menor o igual, igualdad y desigualdad. 

* Ejecuta la función con diferentes valores para mostrar cómo se evalúa la condición y si se ejecuta la sentencia print o no.

* Cubre el uso de "if" y "else" para definir condiciones en Kotlin.

* Explica cómo cambiar la condición con operadores lógicos "and" y "or" para concatenarlas, de modo que se deben cumplir múltiples condiciones para que se ejecute un bloque de código.

* También explica el operador "not" para negar una condición y cómo "if-else" se usa para ejecutar código cuando no se cumple una condición.

* Termina con un ejercicio rápido usando operadores lógicos para evaluar condiciones. 

* La segunda parte se enfoca en entender cuándo usar "when" en lugar de "if" al definir condiciones.

# PARTE 2

* Explica cómo usar operadores lógicos en Kotlin. Usando "and" y "or" se pueden concatenar múltiples condiciones para formar sentencias más complejas.

* Demuestra cómo usar "else if" para evaluar nuevas condiciones después de la sentencia "if" inicial. 

* Cubre el operador de desigualdad, que se usa para indicar si una variable no es igual a un valor específico. 

* Muestra ejemplos de estos conceptos en acción y enfatiza la importancia de construir cuidadosamente las sentencias lógicas.

* Cubre la sentencia de control de flujo "when", similar a un switch en otros lenguajes de programación.

* "When" permite comparar una variable o constante con múltiples valores, por lo que es útil cuando hay muchas opciones posibles.

* El ejemplo compara el valor de una constante cadena con diferentes países y ejecuta diferentes bloques de código según la coincidencia.

* También se discute el operador "not", que puede usarse para negar una condición y evaluar su opuesto.

* En general, la lección cubre conocimientos útiles para decidir qué bloque de código ejecutar.

* Explica el uso de "when" en Kotlin para evaluar diferentes casos para una variable cadena "país".

* El código usa una serie de condiciones para definir valores para diferentes países y sus idiomas asociados.

* Luego demuestra cómo evaluar un rango de valores enteros con "when", usando el ejemplo de la edad de un usuario para definir su etapa de vida.

* El código también incluye una cláusula "else" para capturar casos fuera de los rangos definidos.

* Introduce el concepto de arrays o listas en Kotlin, que se usan para almacenar colecciones de valores del mismo tipo de forma ordenada.

* Explica cómo crear un array y agregar elementos, resaltando que los arrays solo almacenan valores del mismo tipo.

* Muestra cómo imprimir el contenido de un array en la consola y enfatiza que pueden contener valores duplicados.

* Aprendemos a agregar y acceder a datos en listas de Kotlin.

* Podemos agregar datos individuales con .add() o crear una lista de múltiples cadenas separadas por comas. 

* Accedemos a los datos con el índice entre corchetes, iniciando en 0.

* Modificar y eliminar elementos es igualmente fácil. Modificamos asignando un nuevo valor y eliminamos con .removeAt().

* Aprendemos a recorrer la lista con .forEach() para ejecutar una operación en cada elemento.

* Aprendemos sobre varias operaciones que se pueden realizar en arrays de Kotlin, accedidas con un punto después del array.

* Operaciones como count, clear, first, last, sort y sortBy se pueden ejecutar en arrays.

* Aprendemos sobre mapas o diccionarios, estructuras de datos no ordenadas que agrupan diferentes tipos de datos.

* Los elementos de un mapa están asociados a un par clave-valor y las claves no se pueden repetir.

* Los mapas se indexan por una clave, no por su posición como los arrays.

* Creamos una función nueva en Android Studio y una constante con un mapa para demostrar su sintaxis.

* Aprendemos a trabajar con mapas en Kotlin.

* Creamos un mapa vacío y luego agregamos elementos con "mapOf" y "mutableMapOf".

* Vemos cómo agregar un elemento y múltiples elementos en una lista separada por comas.

* Aprendemos sobre la unicidad de claves y cómo actualizar el valor de una clave existente.

* Aprendemos a acceder al valor asociado a una clave con los corchetes.

* Cubre el uso de mapas o diccionarios en Kotlin, incluyendo agregar, acceder, actualizar y eliminar valores.

* También presenta bucles o loops en Kotlin, incluyendo bucles for y while.

* Explica cómo usar bucles for para iterar sobre los elementos de un array o mapa.

* Proporciona un ejemplo con un array y un mapa creados previamente.

* El bucle for se ejecuta una vez por cada elemento para realizar acciones.

* Enseña a los principiantes cómo usar un bucle for para iterar a través de arrays y diccionarios en Kotlin.

* Explica las propiedades de estas estructuras de datos, con los arrays ordenados y los diccionarios desordenados.

* El bucle for puede ejecutarse un cierto número de veces según un rango de números definido, y también se puede establecer un valor de incremento.

* También demuestra cómo usar un bucle while para repetir una acción mientras se cumpla una condición.

* Da una demostración práctica y ejemplos de creación de un array dentro de un rango numérico.

* Cubre dos tipos de bucles en Kotlin: bucles for para iterar sobre arrays y mapas, y bucles while para repetición hasta que se cumpla una condición.

* Destaca la importancia de evitar variables nulas y cómo Kotlin ofrece formas de prevenir errores nulos con variables nullable.

* Demuestra cómo crear variables nullable con el símbolo de interrogación y cómo el compilador evitará que el programa se ejecute si se asignan valores nulos incorrectamente. 

* Enseña a trabajar con variables nullable en Kotlin.

* Demuestra cómo declarar una variable cadena que puede ser nula y mostrar que el programa aún se ejecuta correctamente.

* Luego muestra cómo asegurarse de que una variable nullable no sea nula antes de usarla en el código. 

* Explica el uso del operador de doble admiración y llamadas seguras para trabajar más fácilmente con variables nullable.

* Advierte contra asumir que una variable no es nula y explica los posibles errores.

* Cubre la seguridad nula en Kotlin y cómo trabajar con tipos nullable usando llamadas seguras. 

* Explica cómo usar el operador de llamada segura para evitar errores en tiempo de ejecución causados por valores nulos.

* Introduce el uso de la función "let" para ejecutar código solo cuando el valor no es nulo.

* Enfatiza la importancia de definir variables como nullable y siempre verificar sus valores para evitar errores.

* Además, presenta el concepto de funciones y su importancia, incluyendo reutilización, mejor organización y legibilidad del código.

* Da un ejemplo de cómo crear una función en Kotlin y cómo invocarla.

# PARTE 3

* Enseña sobre funciones en Kotlin, desde funciones simples que imprimen una cadena hasta más complejas con parámetros. 

* Demuestra las desventajas de copiar y pegar código versus los beneficios de crear funciones que pueden realizar tareas repetitivas.

* Explica cómo las funciones con parámetros se pueden usar para personalizar la salida según la entrada proporcionada.

* También demuestra cómo definir y pasar múltiples parámetros a una función. 

* En general, esta sección proporciona una clara introducción a los conceptos básicos de las funciones en Kotlin para principiantes.

* Cubre las funciones en Kotlin. Explica que pueden recibir parámetros y devolver valores, y pueden llamar a otras funciones.

* Demuestra cómo crear una función simple que imprime un mensaje con un parámetro, y luego muestra cómo crear una función con múltiples parámetros que devuelve un valor.

* También explica el uso de la sentencia "return", así como cómo pasar parámetros del tipo de dato correcto.

* Enfatiza la importancia de usar funciones para hacer el código más legible y menos propenso a errores.

* Enseña los conceptos básicos de clases y cómo se usan para agregar funcionalidad a un programa Android definiendo propiedades o métodos dentro de ellas.

* Comenta la función anterior y crea una nueva función "clases", y abre un archivo en Android Studio para mostrar lo fácil que es crear una nueva clase.

* También demuestra cómo crear y usar un objeto de una clase en el código asignando la clase a una constante y pasando los parámetros necesarios.

* Explica que la mayoría del código consistirá en clases para generar objetos con total libertad y funcionalidades que no están disponibles de forma predeterminada en Android.

* El instructor explica cómo usar constructores, propiedades y funciones en clases de Kotlin.

* Muestra cómo crear una clase programer con propiedades como nombre, edad y lenguajes de programación. 

* Explica que si queremos acceder a las propiedades fuera de la clase, debemos indicar si son constantes o variables.

* También demuestra cómo crear una función dentro de una clase para agregar funcionalidad extra a nuestra clase programer.

* Además, presenta cómo usar el tipo de dato enumerado en Kotlin para asegurar que nuestra clase programer contenga solo lenguajes de programación válidos.

* Discute cómo asignar la misma clase a otra clase y cómo indicar que un objeto puede o no tener cierta propiedad.

* Crea los amigos de un programer como una matriz de la clase Programer, donde el constructor se crea como parámetro obligatorio.

* Sin embargo, para evitar errores debido a valores nulos, se da un valor predeterminado nulo a amigos.

* Acceder a un valor nulo se hace con el signo de interrogación, como en el caso de mostrar el nombre del primer amigo de un programer.

* También afirma que estas son solo las bases de Kotlin y que el lenguaje ofrece muchos otros conceptos, como herencia y constructores personalizados, para programación más avanzada.