package com.example.bienvenidosalcurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer  // Necesario para usar efectos gráficos
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.foundation.background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                // Aplicamos el color de fondo a la columna
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFD9E9D3)) // Verde claro de fondo
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ProfileCard()
                }
            }
        }
    }
}

@Composable
fun ProfileCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen circular usando graphicsLayer
        Box(
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
                .aspectRatio(1f)  // Mantener el aspecto cuadrado
                .background(Color.Gray, CircleShape) // Fondo circular
        ) {
            Image(
                painter = painterResource(id = R.drawable.rene),  // Asegúrate de tener la imagen en recursos
                contentDescription = "Profile Image",
                modifier = Modifier
                    .fillMaxSize()  // Hace que la imagen llene el Box
                    .graphicsLayer {
                        shape = CircleShape // Aplica el recorte circular
                        clip = true
                    }
            )
        }

        // Nombre
        Text(
            text = "Jennifer Doe",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Cargo
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Información de contacto
        ContactInfo()
    }
}

@Composable
fun ContactInfo() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Teléfono
        Text(
            text = "📞 +11 (123) 444 555 666",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Redes sociales
        Text(
            text = "📱 @AndroidDev",
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Correo
        Text(
            text = "✉ jen.doe@android.com",
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileCard() {
    MaterialTheme {
        ProfileCard()
    }
}
