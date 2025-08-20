package com.example.weather_app_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.weather_app_1.Helper_Functions.returnListCityOrAddCity

import com.example.weather_app_1.ui.theme.Weather_app_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //TODO Для начала будет Host из городов и они какбы будут в списке
        }
    }
}

@Composable
fun NavigationOnCity() {

    val citys = returnListCityOrAddCity()

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = citys[0]){

    }

}

