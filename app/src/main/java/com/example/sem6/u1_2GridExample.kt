package com.example.sem6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class u1_2GridExample : ComponentActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudentDashboard()
        }
    }

    // ---------------- ROW Example ----------------
    @Composable
    fun SimpleRowExample() {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Text("Android", fontSize = 18.sp)
            Text("Kotlin", fontSize = 18.sp)
            Text("Compose", fontSize = 18.sp)
            Text("Java", fontSize = 18.sp)
            Text("Python", fontSize = 18.sp)
            Text("C++", fontSize = 18.sp)
        }
    }

    // ---------------- COLUMN Example ----------------
    @Composable
    fun SimpleColumnExample()
    {
        Column(modifier = Modifier.padding(16.dp))
        {
            Text("Student 1", fontSize = 18.sp)
            Text("Student 2", fontSize = 18.sp)
            Text("Student 3", fontSize = 18.sp)
        }
    }

    // ---------------- LazyRow Example ----------------
    @Composable
    fun SubjectRow()
    {
        val subjects = listOf("Math", "Science", "English", "History", "Computer")

        LazyRow(modifier = Modifier.padding(16.dp))
        {
            items(subjects) { subject ->
                Card(
                    modifier = Modifier.padding(end = 10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {

                    Text(
                        text = subject,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }

    // ---------------- LazyColumn Example ----------------
    @Composable
    fun StudentList() {

        val students = listOf(
            "Rahul Sharma",
            "Priya Verma",
            "Aman Gupta",
            "Sneha Patel",
            "Vishal Khanna"
        )

        LazyColumn(
            modifier = Modifier.height(250.dp),
            contentPadding = PaddingValues(16.dp)
        ) {

            items(students) { student ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {

                    Text(
                        text = student,
                        modifier = Modifier.padding(16.dp),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }

    // ---------------- Grid Example ----------------
    @Composable
    fun CourseGrid() {

        val courses = listOf(
            "Android",
            "React Native",
            "Flutter",
            "Kotlin",
            "Java",
            "Python","c++", "javascript","xml"
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.height(250.dp),
            contentPadding = PaddingValues(16.dp))
        {

            items(courses) { course ->

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {

                    Box(
                        modifier = Modifier.padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(text = course)

                    }
                }
            }
        }
    }

    // ---------------- Dashboard Screen ----------------
    @Composable
    fun StudentDashboard() {

        LazyColumn {

            item {

                Text(
                    text = "Row Example",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(36.dp)
                )

                SimpleRowExample()

                Text(
                    text = "Column Example",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(16.dp)
                )

                SimpleColumnExample()

                Text(
                    text = "LazyRow Example",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(16.dp)
                )

                SubjectRow()

                Text(
                    text = "LazyColumn Example",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(16.dp)
                )

                StudentList()

                Text(
                    text = "Grid Example",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(16.dp)
                )

                CourseGrid()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable()
    fun gridpreview()
    {
        MaterialTheme() { StudentDashboard()}
    }
}

/**
   1. Header:- CSE 225 - Android UI Components (Top of screen having android logo)
   2. Dropdown menu:- Select category (by default); categories:- languages, frameworks, databases
   3. Programming languages (title/header) with box having options: Java, Kotlin, Python, C++, JavaScript, separated by a line (box as card layout)
   4. Lazy Grid having (title/header) "Technology Grid" having cards: Android, Flutter, React, Firebase, MongoDB, NodeJS along with their pic icon/logo
 * */