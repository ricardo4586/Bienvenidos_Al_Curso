package com.example.bienvenidosalcurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.painterResource
import androidx.core.view.WindowCompat
import com.example.bienvenidosalcurso.ui.theme.BienvenidosAlCursoTheme

// Importar Image y painterResource para la carga de imágenes
import androidx.compose.foundation.Image
// Importar Arrangement para la distribución de los elementos
import androidx.compose.foundation.layout.Arrangement

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilitar el borde a borde en la aplicación
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            BienvenidosAlCursoTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    GreetingCard(modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

@Composable
fun GreetingCard(modifier: Modifier = Modifier) {
    // Especificamos el tipo explícito de mutableStateOf<String>()
    val name = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Usamos Arrangement para distribuir el contenido verticalmente
    ) {
        Text(
            text = "¡Bienvenido al Curso!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "¡Hola, Estudiante!",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Fila con los botones "Aceptar" y "Rechazar"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround // Distribuye los botones horizontalmente
        ) {
            Button(
                onClick = { /* Acción de aceptar */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE),  // Color morado de fondo
                    contentColor = Color.White            // Texto blanco
                )
            ) {
                Text(
                    text = "Aceptar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(
                onClick = { /* Acción de rechazar */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,  // Color rojo de fondo
                    contentColor = Color.White   // Texto blanco
                )
            ) {
                Text(
                    text = "Rechazar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Imagen decorativa
        Image(
            painter = painterResource(id = R.drawable.rene),  // Usa la imagen rene.webp
            contentDescription = "Imagen del curso",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreetingCard() {
    BienvenidosAlCursoTheme {
        GreetingCard()
    }
}
