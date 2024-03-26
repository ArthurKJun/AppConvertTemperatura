package com.example.conversaotemperatura

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.conversaotemperatura.ui.theme.ConversaoTemperaturaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConversaoTemperaturaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp(){

    var celsius = remember {
        mutableStateOf("")
    }

    var cel = remember {
        mutableDoubleStateOf(0.00)
    }

    Column (
        modifier = Modifier
            .padding(32.dp)

    ){
        Text(
            text = "Consversor de Temperaturas",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize =(24.sp)
        )

        OutlinedTextField(
            value = celsius.value,
            onValueChange = { celsius.value = it},
            label = {
                Text(text = "Celsius")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        )

        Button(
            onClick = {
                cel.doubleValue = ((celsius.value.toDouble()*1.8)+32)

            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "CALCULAR")
        }
        
        Text(
            text = "Fahrenheit = ${cel.value} ºF",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()

        )

    }
}

