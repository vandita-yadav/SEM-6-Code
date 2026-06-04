/*package com.example.sem6

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp

class u2_sampleActivity : ComponentActivity()
{
    fun OnCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                smartLearning()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun smartLearning()
{
    Row(modifier = Modifier.fillMaxWidth().padding(20.dp))
    {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopStart)
        {
            Box{
            IconButton(onClick = {})
            {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }}
        }


        var expanded by remember { mutableStateOf(false) }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd)
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
    }
}
























//first part of screen: header:-
//        1. Hamburger icon top left corner, top center title "Smart Learning", top right corner simple menu
//
//second part of screen having 5 sections:
//        section 1:- spinner drop down category (programming languages, web development, app development, data science, ai ml, cyber security) title ("popular courses") with default category: "select category"
//        section 2:-  popular courses sections having title "popular courses" with two cards:- "Kotlin Programming" and "UI/UX Design", adjacent to it star rating, under it, progress bar for each card
//        section 3:- Titled "featured technologies" grid display of 4 card of skills having with icons "java", "android", "ai", "web dev"
//        section 4:- titled "Recommended topics": having scrollable row (lazy row) of cards: machine learning, data science, cyber security etc.
//        section 5: bottom of screen having custom rating bar and progress bar



*/

