package com.example.weather_app_1.Helper_Functions

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app_1.ui.theme.returnMyColor
import com.example.weather_app_1.R
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun CityScreen(
    navController: NavController,
    cities: MutableList<String>
    ) {

    val myColor = returnMyColor()

    val listCity = cities

    val currentIndex = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = myColor.primary)
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(myColor.background)
                    .clickable{
                        navController.navigate("add_city")
                    }
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.add_24),
                    contentDescription = "Add city in list",
                    tint = myColor.primary,
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)

                )
            }
        }

        Spacer(modifier = Modifier.height(250.dp))

        Text(
            text = "${listCity[currentIndex.value]} || ${currentIndex.value} || ${listCity.size}",
            fontSize = 32.sp,
            fontFamily = returnFontFamily(),
            fontWeight = FontWeight.Black
        )

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(myColor.background)
                    .clickable{

                        if (currentIndex.value+1 > listCity.size || currentIndex.value > listCity.size){
                            currentIndex.value = 0
                        }
                        currentIndex.value ++
                    }
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.arrow_right_24),
                    contentDescription = "Add city in list",
                    tint = myColor.primary,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
            }
        }
    }
}