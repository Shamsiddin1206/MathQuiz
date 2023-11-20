package shamsiddin.project.mathquiz.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import shamsiddin.project.mathquiz.navigation.ScreenType
import java.util.logging.Level

@Composable
@Preview
fun NameView(){
    NameScreen(navController = rememberNavController(), "easy")
}

@Composable
fun NameScreen(navController: NavController, level: String){
    Box(modifier = Modifier.fillMaxSize().background(Color.White)){
        Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {navController.navigate(route =  "game_screen/${level}/Shamsiddin")},
                modifier = Modifier
                    .width(150.dp)
                    .height(70.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)
            ){
                Text(text = "Start", color = Color.White, fontSize = 17.sp)
            }
        }
    }
}