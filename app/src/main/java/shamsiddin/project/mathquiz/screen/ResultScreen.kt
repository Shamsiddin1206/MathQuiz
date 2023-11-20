package shamsiddin.project.mathquiz.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import shamsiddin.project.mathquiz.MySharedPreferences

@Composable
fun ResultScreen(navController: NavController, level:String, name:String, score:Int){
    val sharedPreferences = MySharedPreferences.getInstance(LocalContext.current)
    Log.d("Results", "ResultScreen: ${sharedPreferences.getData(level)}")
}