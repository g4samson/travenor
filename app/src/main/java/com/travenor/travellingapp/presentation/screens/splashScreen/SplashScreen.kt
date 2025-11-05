package com.travenor.travellingapp.presentation.screens.splashScreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.travenor.travellingapp.R
import com.travenor.travellingapp.data.utils.Destinations
import com.travenor.travellingapp.presentation.screens.onboardingScreen.OnboardingViewModel
import com.travenor.travellingapp.presentation.theme.Geometr
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.Primary

@Composable
fun SplashScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val skipOnboarding by viewModel.completed.collectAsState(initial = false)
    val offsetY = remember { Animatable(0f) }
    val scale = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1.2f,
            animationSpec = tween(800)
        )

        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(400, easing = FastOutSlowInEasing)
        )

        offsetY.animateTo(
            targetValue = -2000f,
            animationSpec = tween(durationMillis = 900, easing = FastOutSlowInEasing)
        )

        navController.navigate(if (skipOnboarding) Destinations.SignIn else Destinations.Onboarding) {
            popUpTo(navController.graph.startDestinationId) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset { IntOffset(0, offsetY.value.toInt()) },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.logo_main),
                contentDescription = null,
                tint = MainWhite,
                modifier = Modifier
                    .size(200.dp)
                    .graphicsLayer(
                        scaleX = scale.value, scaleY = scale.value
                    )
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                "Travenor",
                fontSize = 34.sp,
                color = MainWhite,
                fontFamily = Geometr,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 50.dp)
            )
        }
    }
}