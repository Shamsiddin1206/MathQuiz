package shamsiddin.project.mathquiz.screen

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import shamsiddin.project.mathquiz.MySharedPreferences
import shamsiddin.project.mathquiz.R
import shamsiddin.project.mathquiz.navigation.ScreenType

@Composable
@Preview
fun ResultScreenView(){
//    ResultScreen()
}

@Composable
fun ResultScreen(navController: NavController, level:String, name:String, score:Int, questionsNumber: Int){
    val sharedPreferences = MySharedPreferences.getInstance(LocalContext.current)
    Log.d("Results", "ResultScreen: ${sharedPreferences.getData(level)}")
    val mySharedPreferences = MySharedPreferences.getInstance(LocalContext.current)
    val text = if (score>sharedPreferences.getData(level)) "Results" else "New Record"

    BackHandler(enabled = true, onBack = {
        navController.navigate(ScreenType.Level.route)
    })

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column() {
            Text(text = text, fontSize = 20.sp, textAlign = TextAlign.Center)
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "trophy",
                alignment = Alignment.Center,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = "Congratulations!",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Row {
                Text(
                    text = score.toString(),
                    color = Color(android.graphics.Color.parseColor("#4CAF50")),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp)
                )
                Text(text = "/",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Black)
                Text(
                    text = questionsNumber.toString(),
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp)
                )

            }
            Row {
                Button(
                    onClick = {
                        navController.navigate(ScreenType.Level.route)
                    },
                    colors = ButtonDefaults.buttonColors((Color(android.graphics.Color.parseColor("#4CAF50")))),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Home")
                }
                Button(
                    onClick = {
                        navController.popBackStack()
                    },
                    colors = ButtonDefaults.buttonColors((Color(android.graphics.Color.parseColor("#FF6200EE")))),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Restart")
                }
            }
        }
    }
}