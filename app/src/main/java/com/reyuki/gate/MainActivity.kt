package com.reyuki.gate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reyuki.gate.ui.theme.GateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GateTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun UserInfoCard() {
    val username = "anon"

    Row(
        Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFD9D9D9))
            .height(IntrinsicSize.Min)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(R.drawable.profile), contentDescription = null, modifier = Modifier.weight(1f).size(50.dp), contentScale = ContentScale.Fit)
        Column(Modifier.weight(3f), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "Welcome back, $username!"
            )
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                Image(painter = painterResource(R.drawable.ic_coin_splash), contentDescription = null, modifier = Modifier.size(25.dp), contentScale = ContentScale.Fit)
                Text(text = "1000", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun LinearDeterminateIndicator() {
    var currentProgress by remember { mutableStateOf(0.15f) }
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .clip(RoundedCornerShape(10.dp)),
        progress = currentProgress,
        color = Color(0xFFFF5151)
    )
}

@Composable
fun DailyInfoCard() {
    Row(
        Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFD9D9D9))
            .height(IntrinsicSize.Min)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(R.drawable.ic_roli_coin), contentDescription = null, modifier = Modifier.weight(1f))
        Column(Modifier.weight(3f), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "Claim daily 15-days coin"
            )
            LinearDeterminateIndicator()
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(onClick = { }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5151))) {
                    Text("Redeem")
                }
            }
        }
    }
}

@Composable
fun ActionGroup() {
    Row(modifier = Modifier.fillMaxWidth().padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5151))) {
            Text("Wheel the coin")
        }
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5151))) {
            Text("Copy session")
        }
    }
}

@Composable
fun MainScreen() {
    Column {
        UserInfoCard()
        DailyInfoCard()
        ActionGroup()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    GateTheme {
        MainScreen()
    }
}