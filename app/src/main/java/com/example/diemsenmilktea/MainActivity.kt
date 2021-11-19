package com.example.diemsenmilktea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.diemsenmilktea.data.FoodData
import com.example.diemsenmilktea.routing.DiemSenMilkTeaRouter
import com.example.diemsenmilktea.routing.Screen
import com.example.diemsenmilktea.ui.theme.DiemSenMilkTeaTheme
import com.example.diemsenmilktea.ui.screens.ListFoodScreen
import com.example.diemsenmilktea.ui.screens.RandomFoodScreen

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiemSenMilkTeaTheme {
                Surface(color = MaterialTheme.colors.background) {
                    when (DiemSenMilkTeaRouter.currentScreen) {
                        is Screen.RandomFood -> RandomFoodScreen(FoodData)
                        is Screen.ListFood -> ListFoodScreen(foodData = FoodData)
                    }
                }
            }
        }
    }
}