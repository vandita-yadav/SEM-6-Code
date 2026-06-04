package com.example.sem6

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

class u1_5SplashExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashApp()
        }
    }
}
@Composable
fun SplashApp()
{
    var showSplash by remember {mutableStateOf(true)}
    if(showSplash)
    {
        SplashScreen{
            showSplash=false
        }
    }
    else {HomeScreen()}
}
@Composable
fun SplashScreen(onTimeout:()->Unit)
{
    LaunchedEffect(Unit) {
        delay(9000)
        onTimeout()
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Text(text = "Welcome to my App", style = MaterialTheme.typography.headlineLarge)
    }
}

@Composable
fun HomeScreen()
{
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Text("Home Screen", style = MaterialTheme.typography.headlineLarge)
    }
}

//7006416585 Arsalan Manzoor Zargar