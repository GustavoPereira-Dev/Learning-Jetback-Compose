package com.example.composerbotao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.composerbotao.ui.theme.ComposerbotaoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppScreen()
        }
    }
}

@Composable
fun MyAppScreen(){
    var contadorExterno by remember{
        mutableStateOf(0)
    }

    ComposerbotaoTheme() {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {

            Column (){
                MyButtonWidgetContadorInter()
                MyButtonWidgetContadorInter()
                MyButtonWidgetContadorExter(contExt = contadorExterno,
                    funQueAtualizaMeuContExt = { contadorIncrementado -> contadorExterno = contadorIncrementado})
                MyButtonWidgetContadorExter(contExt = contadorExterno,
                    funQueAtualizaMeuContExt = { contadorIncrementado -> contadorExterno = contadorIncrementado})

            }
        }
    }
}
@Composable
fun MyButtonWidgetContadorInter(){
    var contadorInterno by remember{
        mutableStateOf(0)
    }
    Button(onClick = { contadorInterno++}){
        Text(text = "Fui clicado $contadorInterno vezes!!!")
    }
}

@Composable
fun MyButtonWidgetContadorExter(
    contExt: Int,
    funQueAtualizaMeuContExt: (Int)->Unit){

    Button(onClick = { funQueAtualizaMeuContExt(contExt + 1)}){
        Text("Fui clicado $contExt vezes!!!")
    }
}