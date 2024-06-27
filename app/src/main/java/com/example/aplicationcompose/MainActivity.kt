package com.example.aplicationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicationcompose.ui.theme.AplicationcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    Scaffold(
        topBar = {MyTopBar()} ,
        bottomBar = { MyBottomBar()}) {
        MyScreenContent()
    }
}

@Composable
fun MyTopBar(){
    TopAppBar(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color(0xFFBB86FC)),
       ) {
        Text(text = "My Top Bar", color = Color.Yellow, fontSize = 25.sp)
    }
}

@Composable
fun MyScreenContent(){
    var contadorExterno by remember{
        mutableStateOf(0)
    }

    Box(modifier = Modifier.fillMaxSize().background(color = Color.Blue)){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Learning Jetback Compose",
                color = Color.DarkGray,
                fontSize = 30.sp,
                modifier = Modifier.width(300.dp),
                fontWeight = FontWeight.Bold
            )
            MyButtonWidgetContadorInter()
            MyButtonWidgetContadorInter()
            MyButtonWidgetContadorExter(contExt = contadorExterno,
                funQueAtualizaMeuContExt = { contadorIncrementado -> contadorExterno = contadorIncrementado})
            MyButtonWidgetContadorExter(contExt = contadorExterno,
                funQueAtualizaMeuContExt = { contadorIncrementado -> contadorExterno = contadorIncrementado})
        }
    }


}

@Composable
fun MyBottomBar(){
    BottomAppBar(modifier = Modifier
        .fillMaxWidth(),
        backgroundColor = Color.Red) {
        Text(text = "Bottom Bar", color = Color.White, fontSize = 15.sp)
    }
}

@Composable
fun MyButtonWidgetContadorInter(){
    var contadorInterno by remember{
        mutableStateOf(0)
    }
    Button(onClick = { contadorInterno++}){
        Text(text = "I was clicked $contadorInterno time(s)!!!", color = Color.Cyan )
    }
}

@Composable
fun MyButtonWidgetContadorExter(
    contExt: Int,
    funQueAtualizaMeuContExt: (Int)->Unit){

    Button(onClick = { funQueAtualizaMeuContExt(contExt + 1)}){
        Text("I was clicked $contExt time(s)!!!", color = Color.Magenta)
    }
}