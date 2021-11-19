package com.example.diemsenmilktea.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diemsenmilktea.data.Food
import com.example.diemsenmilktea.routing.Screen
import com.example.diemsenmilktea.ui.components.AppDrawer
import com.example.diemsenmilktea.ui.components.ShowOneFood
import com.example.diemsenmilktea.ui.components.TopAppBar
import kotlinx.coroutines.launch
import kotlin.random.Random

fun getRandomAFood(
    food: List<Food>
): Food {
    val end = food.size
    var idRandom = Random.nextInt(end )
    return food[idRandom]
}

@Composable
fun RandomFoodScreen(
    food: List<Food>
) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val foodWasRandom = remember {
        mutableStateOf(Food("", 0))
    }

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
                currentScreen = Screen.RandomFood,
                closeDrawerAction = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (food.isNotEmpty()) {
                    if (foodWasRandom.value.name != "") {
                        ShowOneFood(oneFood = foodWasRandom.value)
                    }
                    Button(
                        onClick = {
                            foodWasRandom.value = getRandomAFood(food = food)
                        }, contentPadding = PaddingValues(
                            start = 20.dp,
                            top = 12.dp,
                            end = 20.dp,
                            bottom = 12.dp
                        )
                    ) {
                        Icon(
                            Icons.Filled.Refresh,
                            contentDescription = "Random",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text("Random Food")
                    }
                } else {
                    Text(
                        text = "Không có loại trà sữa nào trong List Food",
                        style = TextStyle(fontSize = 18.sp)
                    )
                }
            }
        },

        )
}
