package shamsiddin.project.mathquiz.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import shamsiddin.project.mathquiz.R

@Composable
fun LevelScreen(navHostController: NavHostController){
    LevelView()
}

@Composable
@Preview
fun LevelView(){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.levelbackground),
            contentDescription = "level"
        )
        Row(modifier = Modifier
            .fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = {},
                    Modifier
                        .padding(10.dp)
                        .width(100.dp),
                    colors = ButtonDefaults.buttonColors(Color.Green)
                ) {
                    Text(text = "Easy")
                }
                Button(onClick = {},
                    Modifier
                        .padding(10.dp)
                        .width(100.dp),
                    colors = ButtonDefaults.buttonColors(Color.Yellow)){
                    Text(text = "Medium")
                }
                Button(onClick = {},
                    Modifier
                        .padding(10.dp)
                        .width(100.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red)) {
                    Text(text = "Hard")
                }
            }
        }
    }
}