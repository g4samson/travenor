package com.travenor.travellingapp.presentation.composable.bottomAppBarComponent

import androidx.lifecycle.ViewModel
import com.travenor.travellingapp.domain.repositories.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomAppBarViewModel @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
) : ViewModel() {

}