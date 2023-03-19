package com.mimo.test2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mimo.test2.ui.theme.Test2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    MainContent {

                        MainScreen()

                    }
        }
    }
}
@Composable
fun MainContent(content: @Composable () -> Unit){
    Test2Theme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
             content()
        }
    }
}
@Composable
fun MainScreen(){
    Card(modifier = Modifier
        .width(200.dp)
        .height(380.dp)
        .padding(10.dp),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = 5.dp
    ) {
        Column(modifier = Modifier.height(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            RoundedImage()
            Divider(modifier = Modifier.width(200.dp))
            Spacer(modifier = Modifier.height(10.dp))
            NameTextBox()
            Spacer(modifier = Modifier.height(10.dp))
            PreviewButton()
        }
    }
}
@Composable
fun RoundedImage(modifier: Modifier = Modifier){
    Surface(modifier = modifier
        .size(180.dp)
        .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 5.dp,
        color = MaterialTheme.colors.onSurface.copy(0.5f)
        ) {
        Image(painter = painterResource(id = R.drawable.profile_pic ),
            contentDescription = "Profile pic",
            modifier = Modifier.size(160.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun NameTextBox(){
    Column(modifier = Modifier.padding(5.dp)) {
        Text(text = "Android Class",
            style = MaterialTheme.typography.h4)
        Text(text = "by i Coders",
            style = MaterialTheme.typography.h5,
            color = Color.LightGray)
    }

}

@Composable
fun PreviewButton(){
    Button(onClick = {

    }) {
        Text(text = "Portfolio", style = MaterialTheme.typography.button)
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Test2Theme {
        MainContent {
            MainScreen()
        }
    }
}