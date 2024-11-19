package com.carlossierrasequera.examenej2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            selectorColor()
        }
    }
}


@Composable
fun selectorColor() {
    var colorSeleccionado by remember { mutableStateOf(Color.Gray) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Selecciona un color:"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ColorList(
            colores = listOf(
                Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Magenta
            ),
            onColorSelected = { color ->
                colorSeleccionado = color
            }
        )
    }
}

@Composable
fun ColorList(colores: List<Color>, onColorSelected: (Color) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        colores.forEach { color ->
            Box(
                modifier = Modifier.clickable { onColorSelected(color) }
            )
        }
    }
}
