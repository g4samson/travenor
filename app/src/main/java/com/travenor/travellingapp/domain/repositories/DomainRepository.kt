package com.travenor.travellingapp.domain.repositories

import com.travenor.travellingapp.data.models.Place
import com.travenor.travellingapp.data.models.PlaceDto

interface DomainRepository {
    //auth
    suspend fun signIn(email: String, password: String): Boolean
    suspend fun signUp(email: String, password: String): Boolean
    suspend fun resetPasswordEmail(email: String): Boolean


    //places
    suspend fun getPlaces(): List<PlaceDto>?
    suspend fun getPlace(id: String): PlaceDto

    suspend fun getImagePublicUrl(path: String?): String
}