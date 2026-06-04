package com.example.sem6
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
data class CourseList(val title: String, val instructor: String, var progress: Float)

class CourseDashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            sampleActivity()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun sampleActivity() {
    val context = LocalContext.current

    val courses = remember {
        mutableStateListOf(
            CourseList("Android", "John", 0.7f),
            CourseList("Data Science", "Robin", 0.5f),
            CourseList("Cyber security", "Bob", 0.3f)
        )
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp))
    {
        Button(onClick = {
            for (i in courses.indices) {
                courses[i] = courses[i].copy(progress = 0f)
            }
        }) {
            Text("Reset Progress")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(courses) { course ->
                CourseItem(course)
            }
        }
    }
}

@Composable
fun CourseItem(course: CourseList) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { Toast.makeText(
                context,
                "Clicked: ${course.title}",
                Toast.LENGTH_SHORT
            ).show() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(text = course.title)
            Text(text = "Instructor: ${course.instructor}")

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { course.progress }
            )

            Text(text = "${(course.progress * 100).toInt()}% completed")
        }
    }
}

