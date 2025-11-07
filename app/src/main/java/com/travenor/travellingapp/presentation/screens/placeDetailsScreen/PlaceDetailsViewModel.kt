package com.travenor.travellingapp.presentation.screens.placeDetailsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.travenor.travellingapp.data.models.Place
import com.travenor.travellingapp.data.models.PlaceDto
import com.travenor.travellingapp.domain.repositories.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaceDetailsViewModel @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
) : ViewModel() {

    private val _place = MutableStateFlow<Place?>(null)
    val place = _place.asStateFlow()

    fun loadPlaceById(id: String) {
        viewModelScope.launch {
            _place.value = domainRepository.getPlace(id).asDomainModel()
        }
    }

    private fun PlaceDto.asDomainModel(): Place {
        return Place(
            id = this.id,
            name = this.name,
            description = this.description,
            address = this.address,
            rate = this.rate,
            price = this.price,
            image = this.image,
            feedbackNumber = this.feedbackNumber
        )
    }
}