package com.example.sem6

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import androidx.datastore.preferences.core.edit
val Context.dataStore by preferencesDataStore("user_prefs")

class U5_1DataStore : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { DataStoreScreen() }
    }
}

@Composable
@Preview(showBackground = true)
fun DataStoreScreen()
{
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var name by remember { mutableStateOf("") }
    var savedName by remember { mutableStateOf("") }

    val NAME_KEY = stringPreferencesKey("name")

    // Load data
    LaunchedEffect(Unit) {
        context.dataStore.data
            .map { preferences -> preferences[NAME_KEY] ?: "" }
            .collect { savedName = it }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Saved Name: $savedName",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter Name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            scope.launch {
                context.dataStore.edit { preferences ->
                    preferences[NAME_KEY] = name
                }
            }
        }) {
            Text("Save")
        }
    }
}