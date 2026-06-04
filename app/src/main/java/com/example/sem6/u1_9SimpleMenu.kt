/*package com.example.sem6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class u1_9SimpleMenu : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                menuExample()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun menuExample()
{
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .statusBarsPadding(),
        contentAlignment = Alignment.TopEnd
    )
    {
        Box {

            IconButton(onClick = { expanded = true })
            {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Menu"
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {

                DropdownMenuItem(
                    text = { Text("Profile") },
                    onClick = { expanded = false }
                )

                DropdownMenuItem(
                    text = { Text("Notifications") },
                    onClick = { expanded = false }
                )

                DropdownMenuItem(
                    text = { Text("Dashboard") },
                    onClick = { expanded = false }
                )

                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = { expanded = false }
                )

                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = { expanded = false }
                )
            }
        }
    }
}*/