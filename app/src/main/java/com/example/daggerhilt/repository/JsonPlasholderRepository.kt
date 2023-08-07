package com.example.daggerhilt.repository

import com.example.daggerhilt.networking.JsonPlaseHolderService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JsonPlasholderRepository @Inject constructor(
    private val jsonPlaseHolderService: JsonPlaseHolderService
){
    fun getJsonPlaceHolderUsers() = flow { emit(jsonPlaseHolderService.getJsonPlaceHolderUsers()) }
}