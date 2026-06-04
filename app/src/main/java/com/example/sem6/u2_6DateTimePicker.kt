package com.example.sem6

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.*

class u2_6DateTimePicker : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { DateTimeScreen() }
    }
}

@Composable
@Preview(showBackground = true)
fun DateTimeScreen()
{
    val context = LocalContext.current

    var selectedDate by remember { mutableStateOf("No date selected") }
    var selectedTime by remember { mutableStateOf("No time selected") }

    val calendar = Calendar.getInstance()

    Column(
        modifier = Modifier.fillMaxSize().padding(40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text("Date & Time Picker", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(20.dp))


        Button(onClick = {
            val datePicker = DatePickerDialog(
                context,
                { _, year, month, dayOfMonth ->
                    selectedDate = "$dayOfMonth/${month + 1}/$year"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }) {
            Text("Select Date")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text("Selected Date: $selectedDate")

        Spacer(modifier = Modifier.height(40.dp))


        Button(onClick = {
            val timePicker = TimePickerDialog(
                context,
                { _, hour, minute ->
                    selectedTime = "$hour:$minute"
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            )
            timePicker.show()
        }) {
            Text("Select Time")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text("Selected Time: $selectedTime")
    }
}