package com.example.sem6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.ui.tooling.preview.Preview


class U5_5HorizontalVerticalPager : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent { PagerScreen() }
    }
}

@Composable
@Preview(showBackground = true)
fun PagerScreen()
{

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(60.dp)
    )
    {
        Text(
            "Horizontal Pager",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        val horizontalPagerState = rememberPagerState(pageCount = { 5 })

        HorizontalPager(
            state = horizontalPagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        { page ->

            val colors = listOf(
                Color(0xFFEF5350),
                Color(0xFF42A5F5),
                Color(0xFF66BB6A),
                Color(0xFFFFCA28),
                Color(0xFFAB47BC)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colors[page]),
                contentAlignment = Alignment.Center
            )
            {
                Text(
                    "Horizontal Page ${page + 1}",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Vertical Pager",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        val verticalPagerState = rememberPagerState(pageCount = { 5 })

        VerticalPager(
            state = verticalPagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .width(150.dp)
        )
        { page ->

            val colors = listOf(
                Color(0xFF8E24AA),
                Color(0xFF3949AB),
                Color(0xFF00897B),
                Color(0xFFF4511E),
                Color(0xFF6D4C41)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colors[page]),
                contentAlignment = Alignment.Center
            )
            {
                Text(
                    "Vertical Page ${page + 1}",
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
            }
        }
    }

}