package com.example.sem6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import android.app.PendingIntent
import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlin.jvm.java

class u2_2A_pendingIntent : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, u2_2B_pendingIntent::class.java).apply {
            putExtra("message", "Hello from notifications")
        }

        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        setContent { firstActivity(pendingIntent) }
    }
}

@Composable
fun firstActivity(pendingIntent:PendingIntent)
{
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    )
    {
        Button(
            onClick = {
                try {
                    pendingIntent.send()  // Trigger PendingIntent
                } catch (e: Exception) {
                    Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("Trigger Pending Intent")
        }
    }
}
