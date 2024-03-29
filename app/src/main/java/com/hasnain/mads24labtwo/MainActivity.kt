package com.hasnain.mads24labtwo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// import com.hasnain.mads24labtwo.ui.theme.MADS24LabTwoTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            TASK FOUR
//            MaterialTheme {
//                Scaffold(
//                    topBar = { TopAppBar(title = { Text("Lazy Grid Layout") }) }
//                ) {
//                    LazyGridContent()
//                }
//            }
//            TASK ONE
//            ColorChangingButton()
//            TASK TWO/THREE
//            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
//                CreateItem(painter = painterResource(id = R.drawable.pic), name = "Hasnain", phoneNumber = "0312", modifier = Modifier.background(color = Color.White))
//                CreateItem(painter = painterResource(id = R.drawable.pic), name = "Memon", phoneNumber = "23432", modifier = Modifier.background(color = Color.White))
//                CreateItem(painter = painterResource(id = R.drawable.pic), name = "Hasnain", phoneNumber = "0312", modifier = Modifier.background(color = Color.White))
//                CreateItem(painter = painterResource(id = R.drawable.pic), name = "Memon", phoneNumber = "23432", modifier = Modifier.background(color = Color.White))
//                CreateItem(painter = painterResource(id = R.drawable.pic), name = "Hasnain", phoneNumber = "0312", modifier = Modifier.background(color = Color.White))
//                CreateItem(painter = painterResource(id = R.drawable.pic), name = "Memon", phoneNumber = "23432", modifier = Modifier.background(color = Color.White))
//                CreateItem(painter = painterResource(id = R.drawable.pic), name = "Hasnain", phoneNumber = "0312", modifier = Modifier.background(color = Color.White))
//                CreateItem(painter = painterResource(id = R.drawable.pic), name = "Memon", phoneNumber = "23432", modifier = Modifier.background(color = Color.White))
//            }
        }
    }
}
@Composable
fun LazyGridContent() {
    val itemsList = listOf(
        Pair(R.drawable.pic, "Dhaka"),
        Pair(R.drawable.pic, "Sundarbans"),
        Pair(R.drawable.pic, "Dhaka"),
        Pair(R.drawable.pic, "Sundarbans"),
        Pair(R.drawable.pic, "Dhaka"),
        Pair(R.drawable.pic, "Sundarbans"),
    )

    LazyColumn {
        items(items = itemsList.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (item in rowItems) {
                    ImageCard(imageResId = item.first, title = item.second)
                }
            }
        }
    }
}

@Composable
fun ImageCard(imageResId: Int, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Text(text=title)
    }
}
@Composable
fun ColorChangingButton() {
    var color by remember { mutableStateOf(Color.Red) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(
            onClick = { color = if (color == Color.Red) Color.Blue else Color.Red },
            colors = ButtonDefaults.buttonColors(color)
        ) {
            Text(text = "Click me")
        }
    }
}
@Composable
fun CreateItem(
    painter: Painter,
    name: String,
    phoneNumber: String,
    modifier: Modifier
){
    Row(modifier = modifier) {
        Image(painter = painter, contentDescription = "Display Picture", modifier = Modifier
            .size(80.dp)
            .clip(
                RoundedCornerShape(10.dp)
            ))
        Column(verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
            .padding(start = 16.dp)
            .weight(1f)) {
            Row {
                Text(text = name)
            }
            Row {
                Text(text = phoneNumber)
            }
        }
    }
}
