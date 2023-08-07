package com.example.daggerhilt.networking

import com.example.daggerhilt.model.github.GithubUser
import retrofit2.http.GET

interface GithubService {

    @GET("users")
    suspend fun getGithubUsers() : List<GithubUser>
}