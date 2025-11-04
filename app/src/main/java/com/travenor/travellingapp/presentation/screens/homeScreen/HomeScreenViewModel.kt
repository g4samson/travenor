package com.travenor.travellingapp.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.travenor.travellingapp.data.models.Place
import com.travenor.travellingapp.data.models.PlaceDto
import com.travenor.travellingapp.domain.repositories.DomainRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
) : ViewModel() {

    private val _placeList = MutableStateFlow<List<Place>?>(listOf())
    val placeList: Flow<List<Place>?> = _placeList
    private val _isLoading = MutableStateFlow(false)
    val isLoading: Flow<Boolean> = _isLoading
    init {
        getPlaces()
    }
    fun getPlaces() {
        viewModelScope.launch {
            val places = domainRepository.getPlaces()
            _placeList.emit(places?.map { it -> it.asDomainModel() })
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