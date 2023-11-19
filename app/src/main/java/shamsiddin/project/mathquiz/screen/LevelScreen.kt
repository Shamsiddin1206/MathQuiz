package shamsiddin.project.mathquiz.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import shamsiddin.project.mathquiz.R
import shamsiddin.project.mathquiz.navigation.ScreenType

@Composable
@Preview
fun LevelView(){
    LevelScreen(navController = rememberNavController())
}


@Composable
fun LevelScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
//        Image(
//            modifier = Modifier.fillMaxSize(),
//            painter = painterResource(id = R.drawable.levelbackground),
//            contentDescription = "level",
//            contentScale = ContentScale.FillBounds
//        )
        Row(Modifier.fillMaxWidth().padding(20.dp), verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center) {
            Image(modifier = Modifier.size(60.dp), painter = painterResource(id = R.drawable.mainlogo), contentDescription = "level")
        }
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                LevelButton(text = "Easy", color = "#4CAF50", navController = navController)
                LevelButton(text = "Medium", color = "#DFB22B", navController = navController)
                LevelButton(text = "Hard", color = "#EC5448", navController = navController)
            }
        }
    }
}


@Composable
fun LevelButton(text: String, color: String, navController: NavController){
    Button(
        onClick = { navController.navigate(ScreenType.Name.route) },
        modifier = Modifier
            .width(170.dp)
            .height(70.dp)
            .padding(10.dp),
        border = BorderStroke(width = 2.dp, color = Color(android.graphics.Color.parseColor(color))),
        colors = ButtonDefaults.buttonColors(Color.White)
    ) {
        Text(text = text, color = Color(android.graphics.Color.parseColor(color)), fontSize = 18.sp)
    }
}