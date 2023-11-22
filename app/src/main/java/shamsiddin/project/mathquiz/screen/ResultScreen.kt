package shamsiddin.project.mathquiz.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import shamsiddin.project.mathquiz.MySharedPreferences

@Composable
@Preview
fun ResultScreen(){
    ResultScreen()
}

@Composable
fun ResultScreen(navController: NavController, level:String, name:String, score:Int){
    val sharedPreferences = MySharedPreferences.getInstance(LocalContext.current)
    Log.d("Results", "ResultScreen: ${sharedPreferences.getData(level)}")

    Box(
        Modifier.fillMaxSize().background(Color.White)
    ){

    }
}