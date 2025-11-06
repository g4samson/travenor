package com.travenor.travellingapp.presentation.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.travenor.travellingapp.data.utils.Destinations
import com.travenor.travellingapp.presentation.composable.NavGraph
import com.travenor.travellingapp.presentation.composable.bottomAppBarComponent.BottomAppBarComponent
import com.travenor.travellingapp.presentation.screens.onboardingScreen.OnboardingViewModel
import com.travenor.travellingapp.presentation.theme.TravellingAppTheme
import dagger.hilt.android.AndroidEntryPoint
import io.github.jan.supabase.SupabaseClient
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var supabaseClient: SupabaseClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravellingAppTheme {
                val navController = rememberNavController()

                val isBottomBarShouldBeShown = remember { mutableStateOf(true) }
                val isTopBarShouldBeShown = remember { mutableStateOf(true) }

                navController.addOnDestinationChangedListener { controller, _, _ ->
                    val route = controller.currentDestination?.route?.substringAfterLast(".")
                    isBottomBarShouldBeShown.value =
                        Destinations.isBottomBarShouldBeShown(route ?: "")
                    Log.i("UI", isBottomBarShouldBeShown.value.toString())
                    isTopBarShouldBeShown.value =
                        Destinations.isTopBarShouldBeShown(route ?: "")
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                            BottomAppBarComponent(navController)

                    }) { innerPadding ->

                    NavGraph(
                        navController = navController,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }

            }
        }
    }
}