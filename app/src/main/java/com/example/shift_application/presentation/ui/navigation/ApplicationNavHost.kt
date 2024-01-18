package com.example.shift_application.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shift_application.common.NavigationConstants
import com.example.shift_application.presentation.AuthViewModel
import com.example.shift_application.presentation.ui.screen.HomeScreen
import com.example.shift_application.presentation.ui.screen.registration.RegistrationScreen


@Composable
fun ApplicationNavHost(authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    val authState = authViewModel.authState.collectAsStateWithLifecycle().value
    val startDestination = if (authState) {
        NavigationConstants.HOME_ROUTE
    } else {
        NavigationConstants.REGISTRATION_ROUTE
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavigationConstants.REGISTRATION_ROUTE) {
            RegistrationScreen(
                registrationViewModel = hiltViewModel(),
                navController = navController
            )
        }
        composable(route = NavigationConstants.HOME_ROUTE) {
            HomeScreen(
                homeViewModel = hiltViewModel(),
                navController = navController
            )
        }
    }
}