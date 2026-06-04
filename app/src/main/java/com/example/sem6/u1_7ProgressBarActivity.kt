package com.example.sem6
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class u1_7ProgressBarActivity  : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Full screen (status bar transparent)
        setContent {
            MaterialTheme { // MaterialTheme provides colors/typography.
                ProgressBarDemo()
            }
        }
    }
}

@Composable
@Preview
fun ProgressBarDemo()
{
    // STATE VARIABLES (drive ALL UI changes)
    var isLoading by remember { mutableStateOf(false) } // true = show indeterminate
    var determinateProgress by remember { mutableStateOf(0f) } // 0.0f to 1.0f = progress %
    val coroutineScope = rememberCoroutineScope() // Safe coroutine launcher

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. BUTTON TO START/STOP
        Button(
            onClick = {
                if (!isLoading) { // 1 => !1 = 0
                    isLoading = true // Show spinning indicators
                    coroutineScope.launch { // Start background simulation
                        simulateProgress { progress ->
                            determinateProgress = progress // Update progress bar
                        }
                    }
                } else {
                    isLoading = false // Stop everything
                    determinateProgress = 0f // Reset progress

                }
            },
            enabled = true
        ) {
            Text(if (isLoading) "Cancel" else "Start Progress")
        }

        // 2. INDETERMINATE CIRCULAR (Spinning wheel)
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(64.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }

        // 3. DETERMINATE CIRCULAR (Progress arc)
        CircularProgressIndicator(
            progress = determinateProgress,
            modifier = Modifier.size(64.dp),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant // Gray background track
        )

        // 4. INDETERMINATE LINEAR (Running bar)
        if (isLoading) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
        }

        // 5. DETERMINATE LINEAR (Filling bar)
        LinearProgressIndicator(
            progress = determinateProgress,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )

        // 6. PROGRESS TEXT
        Text(
            text = "Progress: ${String.format("%.0f", determinateProgress * 100)}%",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

// SIMULATE REAL WORK (like file download)
suspend fun simulateProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100f)
        delay(50)  // 5 second total duration
    }
}