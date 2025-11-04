package com.travenor.travellingapp.domain.repositories

import android.util.Log
import com.travenor.travellingapp.data.models.PlaceDto
import com.travenor.travellingapp.data.providers.SupabaseModule
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.storage.Storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DomainRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest,
    private val storage: Storage,
    private val auth: Auth
) : DomainRepository {

    //auth
    override suspend fun signIn(email: String, password: String): Boolean {
        return try {
            SupabaseModule.provideSupabaseClient()
                .auth.signInWith(Email) {
                    this.email = email
                    this.password = password
                }
            Log.i("GAV", "true sign in")
            true
        } catch (e: Exception) {
            Log.e("GAV", "Exception: ${e.message}")
            false
        }
    }

    override suspend fun signUp(email: String, password: String): Boolean {
        return try {
            SupabaseModule.provideSupabaseClient()
                .auth.signUpWith(Email) {
                    this.email = email
                    this.password = password
                }
            Log.i("GAV", "true sign up")
            true
        } catch (e: Exception) {
            Log.e("GAV", "Exception: ${e.message}")
            false
        }
    }

    override suspend fun resetPasswordEmail(email: String): Boolean {
        return try {
            SupabaseModule.provideSupabaseClient()
                .auth.resetPasswordForEmail(email)
            Log.i("GAV", "true forgot")
            true
        } catch (e: Exception) {
            Log.e("GAV", "Exception: ${e.message}")
            false
        }
    }

    //places
    override suspend fun getPlaces(): List<PlaceDto>? {
        return withContext(Dispatchers.IO) {
            val result = postgrest.from("places")
                .select().decodeList<PlaceDto>()
            result
        }
    }

    override suspend fun getPlace(id: String): PlaceDto {
        return withContext(Dispatchers.IO) {
            postgrest.from("places").select {
                filter {
                    eq("id", id)
                }
            }.decodeSingle<PlaceDto>()
        }
    }

    private fun buildImageUrl(imageFileName: String) =
        "https://uuekwfcmtwhtzpghmowp.supabase.co/storage/v1/object/public/${imageFileName}".replace(" ", "%20")
}