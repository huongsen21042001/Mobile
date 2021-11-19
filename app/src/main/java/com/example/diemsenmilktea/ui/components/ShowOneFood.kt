package com.example.diemsenmilktea.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diemsenmilktea.data.Food

@Composable
fun ShowOneFood(oneFood: Food) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(400.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = 2.dp
    ) {
        Box(modifier = Modifier.height(400.dp)) {
            Image(
                painter = painterResource(id = oneFood.img),
                contentDescription = oneFood.name,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Transparent,
                                Color.Black,
                            ),
                            startY = 50f
                        )
                    ),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = oneFood.name,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}