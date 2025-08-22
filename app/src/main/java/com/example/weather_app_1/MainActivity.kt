package com.example.weather_app_1

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.activity.ComponentActivity
import androidx.navigation.compose.NavHost
import androidx.activity.compose.setContent
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather_app_1.Helper_Functions.AddCity
import com.example.weather_app_1.Helper_Functions.CityScreen
import com.example.weather_app_1.Helper_Functions.Routes
import com.example.weather_app_1.Helper_Functions.returnListCityOrAddCity

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            NavigationOnCity()

        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun NavigationOnCity() {

    val cities = returnListCityOrAddCity(city = null)

    val navController = rememberNavController()

    if (cities.isEmpty()){
        NavHost(navController = navController, startDestination = Routes.AddCity.routes){
            composable(Routes.AddCity.routes) {
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

    } else
    {
        NavHost(
            navController = navController,
            startDestination = Routes.CityWeather.routes,){

            composable(Routes.CityWeather.routes) { CityScreen(navController = navController, cities = cities) }

            composable(Routes.AddCity.routes) {
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
    }
}

