package shamsiddin.project.mathquiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import shamsiddin.project.mathquiz.screen.GameScreen
import shamsiddin.project.mathquiz.screen.LevelScreen
import shamsiddin.project.mathquiz.screen.ResultScreen
import shamsiddin.project.mathquiz.screen.SplashScreen

@Composable
fun SetNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = ScreenType.Splash.route){
        composable(route = ScreenType.Splash.route){
            SplashScreen(navController = navController)
        }
        composable(route = ScreenType.Level.route){
            LevelScreen(navController = navController)
        }
        composable(route = ScreenType.Game.route, arguments = listOf(
            navArgument("level"){
                type = NavType.StringType
            }
        )){entry ->
            val level = entry.arguments?.getString("level")!!
            GameScreen(navController = navController, level)
        }
        composable(route = ScreenType.Result.route, arguments = listOf(
            navArgument("level"){
                type = NavType.StringType
            },
            navArgument("score"){
                type = NavType.IntType
            },
            navArgument("questionsNumber"){
                type = NavType.IntType
            }
        )){entry ->
            val level = entry.arguments?.getString("level")!!
            val score = entry.arguments?.getInt("score")!!
            val questionsNumber = entry.arguments?.getInt("questionsNumber")!!
            ResultScreen(navController = navController, level, score, questionsNumber)
        }
    }
}