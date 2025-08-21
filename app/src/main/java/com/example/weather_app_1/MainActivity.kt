package com.example.weather_app_1

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            NavigationOnCity()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun NavigationOnCity() {

//    val cit = returnListCityOrAddCity()
//
//    val cities = if (cit.isEmpty()) {cit} else {emptyList<String>()}

    val cities: List<String> = listOf("Paris", "Moscow", "New-York", "Tokio")

    val navController = rememberNavController()

//    if (cities.isEmpty()){
//
//        Text( text = "No cities yet. Add one!" )
//        return}

    NavHost(navController = navController, startDestination = cities[0]){

        cities.forEachIndexed { index, city ->

            composable(city) {
                CityScreen(
                    navController = navController,
                    city = city,
                    cities = cities,
                    currentIndex = index
                )
            }
        }

        composable("add_city") {
            AddCity (
                onAddCity = { newCity ->
                    if (newCity.isNotBlank() && !cities.contains(newCity)){
                       // cities.add(newCity)
                    }
                    navController.popBackStack()
                }
            )
        }
    }

}

