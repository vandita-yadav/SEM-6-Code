package com.example.sem6
import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.TabRow
import androidx.compose.runtime.*
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch


class u5_4TabPager : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent { TabPagerScreen() }
    }
}

@Composable
@Preview(showBackground = true)
fun TabPagerScreen()
{
    val tabTitles = listOf("Home", "Profile", "Settings")
    val pagerState = rememberPagerState(pageCount = {tabTitles.size})
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize().padding(30.dp))
    {
        TabRow(selectedTabIndex = pagerState.currentPage)
        {
            tabTitles.forEachIndexed { index, title->
                Tab(
                    selected = pagerState.currentPage==index,
                    onClick = {
                        coroutineScope.launch { pagerState.animateScrollToPage(index) }
                    },
                    text = {Text(title)}
                )
            }

            HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize())
            { page ->
                when (page) {
                    0 -> Text("Home Screen")
                    1 -> Text("Profile Screen")
                    2 -> Text("Settings Screen")
                }
            }
        }
    }
}

@Composable
fun HomeScreenPager()
{
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Text("Home Screen")
    }
}

@Composable
fun ProfileScreenPager()
{
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Text("Profile Screen")
    }
}

@Composable
fun SettingScreenPager()
{
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Text("Settings Screen")
    }
}