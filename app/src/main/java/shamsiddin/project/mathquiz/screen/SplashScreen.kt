package shamsiddin.project.mathquiz.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import shamsiddin.project.mathquiz.R
import shamsiddin.project.mathquiz.navigation.ScreenType

@Composable
fun SplashScreen(navController: NavController){
    var startAnimation by remember{ mutableStateOf(false)}
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        ), label = ""
    )
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(ScreenType.Level.route)
    }
    SplashView(alpha = alphaAnimation.value)
}

@Composable
fun SplashView(alpha : Float){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ){
        Image(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha),
            painter = painterResource(id = R.drawable.mainlogo),
            contentDescription = "splash"
        )
    }
}

@Composable
@Preview
fun SplashPrev(){
    SplashView(alpha = 1f)
}
