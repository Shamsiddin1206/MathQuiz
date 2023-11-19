package shamsiddin.project.mathquiz.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
@Preview
fun NameView(){
    NameScreen(navController = rememberNavController())
}

@Composable
fun NameScreen(navController: NavController){

}