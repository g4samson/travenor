package com.travenor.travellingapp.presentation.composable.cardComponents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.travenor.travellingapp.domain.repositories.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardComponentsViewModel @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
) : ViewModel() {

    private val _favourite = MutableStateFlow(false)
    val favourite: StateFlow<Boolean> = _favourite

    fun onFavouriteChange(newFavourite: Boolean) {
        _favourite.value = newFavourite
    }

    private val _imageUrl = MutableStateFlow<String?>(null)
    val imageUrl: StateFlow<String?> = _imageUrl.asStateFlow()

    fun loadImage(path: String?) {
        viewModelScope.launch {
            _imageUrl.value = domainRepository.getImagePublicUrl(path)
        }
    }


}