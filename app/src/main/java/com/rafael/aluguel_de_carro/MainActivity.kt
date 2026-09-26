package com.rafael.aluguel_de_carro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.rafael.aluguel_de_carro.ui.components.BottomNavigationBar
import com.rafael.aluguel_de_carro.ui.screens.HomeScreen
import com.rafael.aluguel_de_carro.ui.screens.SplashScreen
import com.rafael.aluguel_de_carro.ui.theme.Aluguel_de_CarroTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Aluguel_de_CarroTheme {
                Aplicativo()
            }
        }
    }
}

@Composable
fun Aplicativo() {

    val mostrarSplash = remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {
        delay(2000)
        mostrarSplash.value = false
    }

    if (mostrarSplash.value) {
        SplashScreen()
    } else {
        AppAluguelCarro()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppAluguelCarro() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Aluguel de Carro")
                }
            )
        },

        bottomBar = {
            BottomNavigationBar()
        }

    ) { innerPadding ->

        HomeScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}