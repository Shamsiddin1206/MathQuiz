package shamsiddin.project.mathquiz.screen

import android.os.SystemClock
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import shamsiddin.project.mathquiz.MisolMaker
import shamsiddin.project.mathquiz.R


@Composable
@Preview
fun GameView(){
    GameScreen(navController = rememberNavController(), "easy")
}

@Composable
fun GameScreen(navController: NavController, level: String){
    val score = remember { mutableIntStateOf(0) }
    var timelong: Long = 0
    val test = remember {
        mutableStateOf(MisolMaker.generate(level))
    }

    when(level){
        "easy" -> {
            timelong = 60000
        }
        "medium" -> {
            timelong = 45000
        }
        "hard" -> {
            timelong = 30000
        }
    }

    val timeClock = rememberCountdownTimerState(initialMillis = timelong)




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(android.graphics.Color.parseColor("#9949A9"))),
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Time remaining: ${timeClock.value}", color = Color.White, fontSize = 15.sp)
                }
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Score: ${score.intValue}", color = Color.White)
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, true),
            contentAlignment = Alignment.Center
        ){
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = test.value.a.toString(), fontSize = 36.sp, fontWeight = FontWeight.Normal)
                Image(painter = painterResource(id = R.drawable.blank_icon), contentDescription = "Symbol blank")
                Text(text = test.value.b.toString(), fontSize = 36.sp, fontWeight = FontWeight.Normal)
                Text(text = " = ", fontSize = 36.sp, fontWeight = FontWeight.Normal)
                Text(text = test.value.c.toString(), fontSize = 36.sp, fontWeight = FontWeight.Normal)
            }
        }
    }
}

@Composable
fun rememberCountdownTimerState(initialMillis: Long, step: Long = 1000): MutableState<Long> {
    val timeLeft = remember { mutableLongStateOf(initialMillis) }
    LaunchedEffect(initialMillis, step){
        val startTime = SystemClock.uptimeMillis()
        while (isActive && timeLeft.longValue>0){
            val duration = (SystemClock.uptimeMillis() - startTime).coerceAtLeast(0)
            timeLeft.longValue = (initialMillis - duration).coerceAtLeast(0)
            timeLeft.value /= 1000
            delay(step.coerceAtMost(timeLeft.value))
        }
    }
    return timeLeft
}