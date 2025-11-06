package com.travenor.travellingapp.presentation.screens.signUpScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.travenor.travellingapp.data.utils.Destinations
import com.travenor.travellingapp.presentation.composable.DefaultButton
import com.travenor.travellingapp.presentation.composable.DefaultTextField
import com.travenor.travellingapp.presentation.composable.QuestionComponent
import com.travenor.travellingapp.presentation.composable.SocialNetworkComponent
import com.travenor.travellingapp.presentation.composable.TopAppBarComponent
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.TextColor
import com.travenor.travellingapp.presentation.theme.Typography
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: SignUpViewModel = hiltViewModel<SignUpViewModel>()
) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()

    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val localSoftwareKeyboardController = LocalSoftwareKeyboardController.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainWhite)
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(140.dp))

        Text("Sign up now", style = Typography.titleMedium)
        Spacer(Modifier.height(12.dp))
        Text("Please fill the details and create account", style = Typography.bodyMedium)
        Spacer(Modifier.height(40.dp))

        DefaultTextField("Name Surname", false) { viewModel.onNameChange(it) }

        Spacer(Modifier.height(24.dp))

        DefaultTextField("Email Address", false) { viewModel.onEmailChange(it) }

        Spacer(Modifier.height(24.dp))

        DefaultTextField("Password", true) { viewModel.onPasswordChange(it) }

        Spacer(Modifier.height(40.dp))

        DefaultButton("Sign Up") {
            localSoftwareKeyboardController?.hide()
            viewModel.onSignUp { success ->
                coroutineScope.launch {
                    if (success) {
                        snackBarHostState.showSnackbar(
                            message = "Account created successfully. Signing in!",
                            duration = SnackbarDuration.Short
                        )
                        navController.navigate(Destinations.Home) {
                            popUpTo(navController.graph.startDestinationId) { inclusive = true }
                        }
                    } else {
                        snackBarHostState.showSnackbar(
                            message = "Invalid email or password",
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(40.dp))

        QuestionComponent("Already have an account", "Sign in", 36.dp) {
            navController.navigate(
                Destinations.SignIn
            )
        }

        SocialNetworkComponent({}, {}, {})

        Spacer(Modifier.height(50.dp))
    }

    SnackbarHost(
        hostState = snackBarHostState,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 100.dp),
        snackbar = { data ->
            Snackbar(
                containerColor = TextColor,
                contentColor = MainWhite,
                shape = RoundedCornerShape(15.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = data.visuals.message, color = MainWhite)
                    Spacer(Modifier.height(16.dp))
                    CircularProgressIndicator(
                        modifier = Modifier.width(50.dp),
                        color = MainWhite,
                        strokeWidth = 3.dp
                    )
                }
            }
        }
    )

    TopAppBarComponent("") { navController.navigateUp() }
}