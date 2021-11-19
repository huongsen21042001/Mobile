package com.example.diemsenmilktea.routing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

sealed class Screen {
  object ListFood : Screen()
  object RandomFood : Screen()
}

object DiemSenMilkTeaRouter {
  var currentScreen: Screen by mutableStateOf(Screen.RandomFood)

  fun navigateTo(destination: Screen) {
    currentScreen = destination
  }
}
