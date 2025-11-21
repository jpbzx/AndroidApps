package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("Bessa", "CounterApp creation"))
                    IncreaseCounter()
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)
@Composable
fun MessageCard(msg: Message, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top,
        modifier = modifier.padding(top = 50.dp, start = 25.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.profile_pic_background),
                contentDescription = "ProfilePic",
                modifier
                    .size(40.dp)
                    .clip(CircleShape),
                alignment = Alignment.Center
            )
            Spacer(modifier.width(8.dp))
            Column {
                Text(text = msg.author)
                Spacer(modifier.height(4.dp))
                Text(text = msg.body)
            }
    }
}

@Composable
fun IncreaseCounter(){
    var counter by remember { mutableIntStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = { counter++ }) {
            Text(text = "Increment")
        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(
            text = "$counter",
            fontSize = 25.sp
        )
    }
}