package shamsiddin.project.mathquiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import shamsiddin.project.mathquiz.screen.LevelScreen
import shamsiddin.project.mathquiz.screen.SplashScreen

@Composable
fun SetNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = ScreenType.Splash.route){
        composable(route = ScreenType.Splash.route){
            SplashScreen(navHostController = navController)
        }
        composable(route = ScreenType.Level.route){
            LevelScreen(navHostController = navController)
        }
//        composable(route = ScreenType.Level.route){
//            NameScreen(navHostController = navController)
//        }
//        composable(route = ScreenType.Home.route){
//            MainActivity()
//        }
    }
}