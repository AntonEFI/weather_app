package com.example.weather_app_1.Helper_Functions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.weather_app_1.R

sealed class Routes(val routes: String){

    object AddCity: Routes(routes = "add_city")
    object CityWeather: Routes(routes = "city_weather")
}

@Composable
fun returnListCityOrAddCity(city: String?): MutableList<String>{

    val cityList = remember {
        mutableStateListOf("Moscow", "Paris", "Tokyo", "Rim", "New-York")
    }

    if (city!=null){
        cityList.add(city)
    }

    return cityList
}

fun returnFontFamily(): FontFamily{

    val myCustomFont = FontFamily(
        Font( R.font.sfcompacttext_bold, FontWeight.Bold),
        Font(R.font.sfcompacttext_heavy, FontWeight.Black),
        Font(R.font.sfcompacttext_medium, FontWeight.Normal)
    )

    return myCustomFont

}