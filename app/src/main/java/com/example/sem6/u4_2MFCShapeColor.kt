package com.example.myfirstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MFC_ShapeColor : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomUIApp()
        }
    }
}


@Composable
fun CustomUIApp() {
    MaterialTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {

    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        CustomText(
            text = "Custom Components Demo",
            color = Color.Blue,
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextField(
            value = name,
            onValueChange = { name = it },
            label = "Enter Name"
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomButton(
            text = "Submit",
            onClick = { }
        )
    }
}

@Composable
fun CustomText(
    text: String,
    color: Color = Color.Black,
    fontSize: androidx.compose.ui.unit.TextUnit = 18.sp,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        modifier = modifier
    )
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFE3F2FD),
            unfocusedContainerColor = Color(0xFFF5F5F5)
        )
    )
}

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF6200EE),
            contentColor = Color.White
        )
    ) {
        Text(text = text)
    }
}
