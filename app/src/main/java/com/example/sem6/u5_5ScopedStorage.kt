package com.example.sem6
import android.content.ContentValues
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ScopedStorageActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScopedStorageScreen {
                saveFile()
            }
        }
    }

    private fun saveFile() {

        val values = ContentValues().apply {
            put(MediaStore.Downloads.DISPLAY_NAME, "DemoFile.txt")
            put(MediaStore.Downloads.MIME_TYPE, "text/plain")

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                put(
                    MediaStore.Downloads.RELATIVE_PATH,
                    Environment.DIRECTORY_DOWNLOADS
                )
            }
        }

        val uri = contentResolver.insert(
            MediaStore.Downloads.EXTERNAL_CONTENT_URI,
            values
        )

        uri?.let {
            contentResolver.openOutputStream(it)?.use { output ->
                output.write("Hello Scoped Storage".toByteArray())
            }

            Toast.makeText(
                this,
                "File Saved Successfully",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

@Composable
fun ScopedStorageScreen(onSave: () -> Unit) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onSave) {
            Text("Save File")
        }
    }
}