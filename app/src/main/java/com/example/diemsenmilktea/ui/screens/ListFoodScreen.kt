package com.example.diemsenmilktea.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.diemsenmilktea.data.Food
import com.example.diemsenmilktea.routing.Screen
import com.example.diemsenmilktea.ui.components.AppDrawer
import com.example.diemsenmilktea.ui.components.ShowOneFood
import com.example.diemsenmilktea.ui.components.TopAppBar
import kotlinx.coroutines.launch

@Composable
fun ListFoodScreen(foodData: List<Food>) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = "Diễm Sen Milk Tea",
                icon = Icons.Filled.List,
                onIconClick = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(
                currentScreen = Screen.ListFood,
                closeDrawerAction = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
        },
        content = {
            Content(
                foodData = foodData
            )
        }
    )
}

@Composable
private fun Content(
    foodData: List<Food>,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(count = foodData.size) { foodIndex ->
            val eachFood = foodData[foodIndex]
            ShowOneFood(
                oneFood = eachFood,
            )
        }
    }
}


