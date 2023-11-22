package shamsiddin.project.mathquiz.navigation

sealed class ScreenType(val route: String){
    object Splash: ScreenType("splash_screen")
    object Level: ScreenType("level_screen")
    object Name: ScreenType("name_screen" + "/{level}")
    object Game: ScreenType("game_screen"+ "/{level}")
    object Result: ScreenType("result_screen"+ "/{level}/{score}/{questionsNumber}")
}
