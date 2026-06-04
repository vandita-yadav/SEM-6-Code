package com.example.sem6

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.content.pm.PackageManager

class u2_5NotificationExample : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        createNotificationChannel()
        setContent { NotificationScreen() }
    }

    private fun createNotificationChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            val channel = NotificationChannel(
                "my_channel_id",
                "My Notifications",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Channel for demo notifications"
            }

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}

@Composable
fun NotificationScreen()
{
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            requestPermission(context)
            showNotification(context)
        }) {
            Text("Show Notification")
        }
    }
}


fun requestPermission(context: Context)
{
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
    {
        ActivityCompat.requestPermissions(
            context as ComponentActivity,
            arrayOf(Manifest.permission.POST_NOTIFICATIONS),
            1
        )
    }
}


fun showNotification(context: Context)
{
    val intent = Intent(context, u2_5NotificationExample::class.java)

    val pendingIntent = PendingIntent.getActivity(
        context,
        0,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(context, "my_channel_id")
        .setSmallIcon(android.R.drawable.ic_dialog_info) // REQUIRED
        .setContentTitle("Demo Notification")
        .setContentText("Hello! This is your notification.")
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)

    val notificationManager = NotificationManagerCompat.from(context)

    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
        ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        notificationManager.notify(1, builder.build())
    }
}