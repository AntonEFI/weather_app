package com.example.weather_app_1.Helper_Functions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weather_app_1.ui.theme.returnMyColor

@Composable
fun AddCity(onAddCity: (String) -> Unit) {

    val newCity = remember { mutableStateOf("") }

    val myColor = returnMyColor()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(myColor.primary)
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add a new city",
            fontSize = 32.sp,
            fontFamily = returnFontFamily(),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(60.dp))

        TextField(
            value = newCity.value,
            onValueChange = {
                it -> newCity.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = myColor.primary,
                unfocusedContainerColor = myColor.primary,
                focusedTextColor = myColor.background,
                unfocusedTextColor = myColor.outline,
                focusedLabelColor = myColor.background,
                unfocusedLabelColor = myColor.outline
            ),
            label = {
                Text(
                    text = "Name city"
                )
            }
        )
        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { //TODO падает при моем добавлении и при переходе за границы списка
                onAddCity(newCity.value)
            },
            modifier = Modifier
                .width(250.dp)
                .height(60.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = myColor.background
            )
        ) {

            Text(
                text = "Add City",
                fontSize = 24.sp,
                fontFamily = returnFontFamily(),
                fontWeight = FontWeight.Bold,
                color = myColor.primary
            )
        }
    }
}