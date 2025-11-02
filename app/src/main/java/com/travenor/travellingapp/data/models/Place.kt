package com.travenor.travellingapp.data.models

data class Place(
    val id: String,
    val name: String,
    val description: String,
    val address: String,
    val rate: Double,
    val price: Double,
    val image: String?,
)
