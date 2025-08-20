package com.example.weather_app_1.Helper_Functions

import android.graphics.fonts.Font
import android.graphics.fonts.FontFamily
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app_1.ui.theme.returnMyColor
import com.example.weather_app_1.R

@RequiresApi(Build.VERSION_CODES.Q)
@Preview(showSystemUi = true)
@Composable
fun CityScreen() {

    val myColor = returnMyColor()
//    val myCustomFont = FontFamily(
//        Font(R.font.sfcompacttext_bold)
//    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = myColor.primary)
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Paris",
            fontSize = 28.sp,
            fontStyle = F
        )
    }

}