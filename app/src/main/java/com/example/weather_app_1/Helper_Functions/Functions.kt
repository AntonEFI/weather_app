package com.example.weather_app_1.Helper_Functions

sealed class Routes(val routes: String){

    object City: Routes(routes = "Paris")
    object City1: Routes(routes = "Moscow")
    object City2: Routes(routes = "New-York")
    object City3: Routes(routes = "Tokio")

}

fun returnListCityOrAddCity(city: String? = null): MutableList<String>{

    val cityList: MutableList<String> = mutableListOf(
        Routes.City.routes,
        Routes.City1.routes,
        Routes.City2.routes,
        Routes.City3.routes)

    if (city!!.isNotEmpty()){
        cityList.add(city)
    }

    return cityList
}