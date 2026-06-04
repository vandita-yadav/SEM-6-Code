package com.example.sem6
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


class NavigationDrawerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DrawerExample()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerExample() {

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(

        drawerState = drawerState,

        drawerContent = {
            ModalDrawerSheet {

                Text(
                    text = "Home",
                    modifier = Modifier.padding(16.dp)
                )

                Text(
                    text = "Profile",
                    modifier = Modifier.padding(16.dp)
                )

                Text(
                    text = "Settings",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

    ) {

        Scaffold(

            topBar = {

                TopAppBar(

                    title = {
                        Text("Navigation Drawer")
                    },

                    navigationIcon = {

                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }

        ) { padding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            )
        }
    }
}