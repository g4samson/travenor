package com.travenor.travellingapp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaceDto(
    @SerialName("id")
    val id: String,

    @SerialName("name")
    val name: String,

    @SerialName("description")
    val description: String,

    @SerialName("address")
    val address: String,

    @SerialName("rate")
    val rate: Double,

    @SerialName("price")
    val price: Double,

    @SerialName("image")
    val image: String?,
)