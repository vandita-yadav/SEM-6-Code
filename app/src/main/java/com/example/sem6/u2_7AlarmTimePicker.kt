package com.example.sem6

import android.app.*
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

class u2_7AlarmTimePicker : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AlarmScreen(this) }
    }
}

@Composable
@Preview(showBackground = true)
fun AlarmScreen(context: Context = androidx.compose.ui.platform.LocalContext.current) {

    var hour by remember { mutableStateOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) }
    var minute by remember { mutableStateOf(Calendar.getInstance().get(Calendar.MINUTE)) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Alarm Manager with Time Picker")

        Spacer(modifier = Modifier.height(20.dp))

        AndroidView(
            factory = { ctx ->
                TimePicker(ctx).apply {
                    setIs24HourView(true)
                    hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
                    minute = Calendar.getInstance().get(Calendar.MINUTE)

                    setOnTimeChangedListener { _, h, m ->
                        hour = h
                        minute = m
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            if (checkExactAlarmPermission(context)) {
                setAlarm(context, hour, minute)
            } else {
                requestExactAlarmPermission(context)
            }
        }) {
            Text("Set Alarm")
        }
    }
}

/* ---------- PERMISSION FUNCTIONS ---------- */

fun checkExactAlarmPermission(context: Context): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.canScheduleExactAlarms()
    } else {
        true
    }
}

fun requestExactAlarmPermission(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM).apply {
            data = Uri.parse("package:${context.packageName}")
        }
        context.startActivity(intent)
    }
}

/* ---------- SET ALARM ---------- */

fun setAlarm(context: Context, hour: Int, minute: Int) {

    val calendar = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, hour)
        set(Calendar.MINUTE, minute)
        set(Calendar.SECOND, 0)

        if (before(Calendar.getInstance())) {
            add(Calendar.DATE, 1)
        }
    }

    val intent = Intent(context, u2_7AlarmReciever2::class.java)

    val pendingIntent = PendingIntent.getBroadcast(
        context,
        0,
        intent,
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    alarmManager.setExact(
        AlarmManager.RTC_WAKEUP,
        calendar.timeInMillis,
        pendingIntent
    )

    Toast.makeText(context, "Alarm Set!", Toast.LENGTH_SHORT).show()
}