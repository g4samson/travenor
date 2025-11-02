package com.travenor.travellingapp.presentation.screens.forgotPasswordScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.travenor.travellingapp.domain.repositories.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
) : ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    fun onEmailChange(email: String) {
        _email.value = email
    }

    fun onResetPassword(onResult: (Boolean) -> Unit) {
        viewModelScope.launch {

        }
    }
}