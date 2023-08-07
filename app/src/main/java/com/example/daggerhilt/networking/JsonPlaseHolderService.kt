package com.example.daggerhilt.networking


import com.example.daggerhilt.model.UserData
import retrofit2.http.GET

interface JsonPlaseHolderService {

    @GET("users")
    suspend fun getJsonPlaceHolderUsers() : List<UserData>
}