package com.example.estudos_jetpack_compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

interface Routes {
    val route: String
    val screen: @Composable (navController: NavHostController) -> Unit
}


object Main : Routes {
    override val route: String
        get() = "main_screen"
    override val screen: @Composable (navController: NavHostController) -> Unit
        get() = { navController ->  MainScreen(navController) }

}

object Second : Routes {
    override val route: String
        get() = "second_screen"
    override val screen: @Composable (navController: NavHostController) -> Unit
        get() = { SecondScreen() }
}
