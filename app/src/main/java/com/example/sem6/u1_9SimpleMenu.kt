package com.example.sem6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class u1_9SimpleMenu : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                SimpleMenuScreen()
            }
        }
    }


}

@Composable
@Preview(showBackground = true)
fun SimpleMenuScreen() {


    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("No option selected") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.TopEnd
    ) {

        Column(horizontalAlignment = Alignment.End) {

            Button(
                onClick = { expanded = true }
            ) {
                Text("Open Menu")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {

                DropdownMenuItem(
                    text = { Text("Profile") },
                    onClick = {
                        selectedOption = "Profile"
                        expanded = false
                    }
                )

                DropdownMenuItem(
                    text = { Text("Dashboard") },
                    onClick = {
                        selectedOption = "Dashboard"
                        expanded = false
                    }
                )

                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = {
                        selectedOption = "Settings"
                        expanded = false
                    }
                )

                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = {
                        selectedOption = "Logout"
                        expanded = false
                    }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Selected: $selectedOption"
            )
        }
    }


}
