package com.example.sem6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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

class u1_1List_Grid : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudentDashboard()
        }

    }
    @Composable
    fun StudentList() {
        val students = listOf(
            "Rahul Sharma",
            "Priya Verma",
            "Aman Gupta",
            "Sneha Patel",
            "Vishal Khanna",
            "Anjali Singh",
            "Rahul Sharma",
            "Priya Verma",
            "Aman Gupta",
            "Sneha Patel",
            "Vishal Khanna",
            "Anjali Singh",
            "Rahul Sharma",
            "Priya Verma",
            "Aman Gupta",
            "Sneha Patel",
            "Vishal Khanna",
            "Anjali Singh"
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
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

    @Composable
    fun SubjectRow() {
        val subjects = listOf("Math", "Physics", "Chemistry", "Biology", "English", "History", "Computer", "Geography", "Arts")

        LazyRow(
            modifier = Modifier.padding(16.dp)
        ) {
            items(subjects) { subject ->
                Card(
                    modifier = Modifier
                        .padding(end = 8.dp),
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

    @Composable
    fun CourseGrid() {
        val courses = listOf(
            "Android",
            "React Native",
            "Flutter",
            "Kotlin",
            "Java",
            "Python"
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(courses) { course ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = course)
                    }
                }
            }
        }
    }

    @Composable
    fun StudentDashboard() {
        Column {
            Text(
                text = "Subjects",
                fontSize = 22.sp,
//                modifier = Modifier.padding(16.dp)
                modifier = Modifier.padding(
                    top = 32.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp
                )
            )
            SubjectRow()

            Text(
                text = "Students",
                fontSize = 22.sp,
                modifier = Modifier.padding(16.dp)
            )
            StudentList()
        }
    }

    @Preview(showBackground = true)
    @Composable()
    fun listpreview()
    {
        MaterialTheme() { StudentDashboard()}

    }
}