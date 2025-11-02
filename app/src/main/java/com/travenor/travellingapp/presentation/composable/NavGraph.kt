package com.travenor.travellingapp.presentation.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.travenor.travellingapp.data.utils.Destinations
import com.travenor.travellingapp.presentation.screens.homeScreen.HomeScreen
import com.travenor.travellingapp.presentation.screens.onboardingScreen.OnboardingScreen
import com.travenor.travellingapp.presentation.screens.onboardingScreen.OnboardingViewModel
import com.travenor.travellingapp.presentation.screens.signInScreen.SignInScreen
import com.travenor.travellingapp.presentation.screens.signUpScreen.SignUpScreen
import com.travenor.travellingapp.presentation.screens.splashScreen.SplashScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    NavHost(navController = navController, startDestination = Destinations.Splash) {
        composable<Destinations.Splash> { SplashScreen(navController) }
        composable<Destinations.Onboarding> { OnboardingScreen(navController) }

        composable<Destinations.SignIn> { SignInScreen(navController) }
        composable<Destinations.SignUp> { SignUpScreen(navController) }

        composable<Destinations.Home> { HomeScreen(navController) }
    }
    
}