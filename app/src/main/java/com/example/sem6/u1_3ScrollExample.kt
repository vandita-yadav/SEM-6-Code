package com.example.sem6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class u1_3ScrollExample  : ComponentActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //ScrollExample();
            //HorizontalScrollExample()
            NestedScrollExample()
        }
    }
    @Composable
    fun ScrollExample() {

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {

            for (i in 1..60) {
                Text(
                    text = "Item $i",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(10.dp))
            }

        }
    }
    @Composable
    fun HorizontalScrollExample() {

        val scrollState = rememberScrollState()

        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(36.dp)
        ) {

            for (i in 1..20) {
                Text(
                    text = "Item $i  ",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
    @Composable
    fun NestedScrollExample() {

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(46.dp)
        ) {

            Text(
                text = "Top Section",
                fontSize = 24.sp,
                modifier = Modifier.padding(10.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .height(400.dp)
            ) {

                items(50) { index ->
                    Text(
                        text = "Nested Item $index",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }

            }

            Text(
                text = "Bottom Section",
                fontSize = 24.sp,
                modifier = Modifier.padding(10.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .height(400.dp)
            ) {

                items(50) { index ->
                    Text(
                        text = "Nested Scroll Item $index",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }

            }

        }
    }
    @Preview(showBackground = true)
    @Composable()
    fun scrollpreview()
    {
        MaterialTheme() { ScrollExample()}
    }
}