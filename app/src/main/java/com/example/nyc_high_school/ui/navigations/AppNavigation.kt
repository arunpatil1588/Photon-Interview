package com.example.nyc_high_school.ui.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nyc_high_school.ui.screens.SchoolDetailsScreen
import com.example.nyc_high_school.ui.screens.SchoolListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "school_list") {
        composable("school_list") {
            SchoolListScreen(navController = navController)
        }
        composable(
            "school_details/{name}/{math}/{reading}/{writing}",
            arguments = listOf()
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val math = backStackEntry.arguments?.getString("math")
            val reading = backStackEntry.arguments?.getString("reading")
            val writing = backStackEntry.arguments?.getString("writing")
            SchoolDetailsScreen(
                name = name.orEmpty(),
                math = math,
                reading = reading,
                writing = writing
            )
        }
    }
}