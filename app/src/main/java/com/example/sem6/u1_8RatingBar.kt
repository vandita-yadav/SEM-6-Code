/*package com.example.sem6
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row  
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Star
//import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class u1_8RatingBar: ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MaterialTheme {RatingScreen() } }
    }
}


@Composable
@Preview(showBackground = true)
fun RatingScreen()
{
    var rating by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text( text="Rate this application", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(20.dp))
        CustomRatingBar(rating = rating, onRatingChanged = {rating = it})
        Spacer(modifier = Modifier.height(20.dp))
        Text( text="Your rating: $rating/5", style = MaterialTheme.typography.titleLarge)
    }
}

@Composable
fun CustomRatingBar(maxStars: Int = 5, rating:Int, onRatingChanged:(Int)->Unit)
{
    Row{
        for(x in 1..maxStars)
        {
            Icon(
                imageVector = if(x<=rating)Icons.Filled.Star
                else Icons.Outlined.Star,

                contentDescription = "Star $x", tint = if(x<=rating) Color(0xFFFFC107)
                else Color.Gray,

                modifier = Modifier.size(40.dp).padding(4.dp).clickable{onRatingChanged(x)}
            )
        }
    }
}*/