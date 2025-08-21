package com.example.weather_app_1.Helper_Functions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.weather_app_1.R

sealed class Routes(val routes: String){

    object City: Routes(routes = "Paris")
    object City1: Routes(routes = "Moscow")
    object City2: Routes(routes = "New-York")
    object City3: Routes(routes = "Tokio")

}

@Composable
fun returnListCityOrAddCity(): MutableList<String>{

    val cityList = remember {
        mutableStateListOf(Routes.City.routes,
            Routes.City1.routes,
            Routes.City2.routes,
            Routes.City3.routes)
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