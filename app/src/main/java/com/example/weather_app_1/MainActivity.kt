package com.example.weather_app_1

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.weather_app_1.Helper_Functions.AddCity
import com.example.weather_app_1.Helper_Functions.CityScreen
import com.example.weather_app_1.Helper_Functions.returnListCityOrAddCity

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val cities = returnListCityOrAddCity(city = null)

            NavigationOnCity(cities = cities)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun NavigationOnCity(cities: MutableList<String>) {

    //TODO А вот что если сюда передавать

    //val cities = returnListCityOrAddCity(city = null)

    val navController = rememberNavController()

    val addCity: String = "add_city"

    LaunchedEffect(cities.size) {
        val currentRoute = navController.currentDestination?.route

        if (currentRoute != null && currentRoute != addCity && !cities.contains(currentRoute)){
            navController.navigate(cities.firstOrNull() ?: addCity)
        }
    }

    if (cities.isEmpty()){

        NavHost(navController = navController, startDestination = addCity){
            composable(addCity) {
                AddCity (
                    onAddCity = { newCity ->
                        if (newCity.isNotBlank() && !cities.contains(newCity)){
                            cities.add(newCity)
                        }
                        navController.popBackStack()
                    }
                )
            }
        }

    } else{

        //TODO Помощь : jetpack compose android studio kotlin NavHost отслеживать изменения в каличестве маршрутов

        //TODO да и при добавлении падает. я вот тут подумал что когда я дохожу до края известного списка, я должне вернуться на MainActivity и снова получить список

        // Основной NavHost с key для динамического обновления при изменении cities
        NavHost(
            navController = navController,
            startDestination = cities.first(),
            route = cities.hashCode().toString()){// Ключ зависит от списка — при изменении списка NavHost

            cities.forEachIndexed { index, city ->

                composable(city) {
                    CityScreen(
                        navController = navController,
                        city = city,
                    )
                }
            }

            composable(addCity) {
                AddCity (
                    onAddCity = { newCity ->
                        if (newCity.isNotBlank() && !cities.contains(newCity)){
                            cities.add(newCity)

                            navController.navigate(newCity){
                                popUpTo(navController.graph.startDestinationId) {inclusive = false}
                            }
                        }
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

