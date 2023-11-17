package shamsiddin.project.mathquiz.navigation

sealed class ScreenType(val route: String){
    object Splash: ScreenType("splash_screen")
    object Level: ScreenType("level_screen")
    object Name: ScreenType("name_screen")
    object Home: ScreenType("home_screen")
}
