package com.example.sem6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class u4_3ShapeColor : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShapesScreen()
        }
    }
}

@Composable
fun ShapesScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Shapes Demo",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Rectangle
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color(0xFFEF5350))
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Rounded Rectangle
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = Color(0xFF42A5F5),
                    shape = RoundedCornerShape(16.dp)
                )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Circle
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = Color(0xFF66BB6A),
                    shape = CircleShape
                )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Cut Corner Shape
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = Color(0xFFFFCA28),
                    shape = CutCornerShape(20.dp)
                )
        )
    }
}