package com.travenor.travellingapp.presentation.composable.bottomAppBarComponent

import androidx.lifecycle.ViewModel
import com.travenor.travellingapp.domain.repositories.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class BottomAppBarViewModel : ViewModel() {

    private val _selectedIndex = MutableStateFlow(1)
    val selectedIndex: StateFlow<Int> = _selectedIndex

    fun select(index: Int) {
        _selectedIndex.value = index
    }
}