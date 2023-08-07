package com.example.daggerhilt.repository

import com.example.daggerhilt.database.dao.GithubUserDao
import com.example.daggerhilt.networking.GithubService
import com.example.daggerhilt.networking.JsonPlaseHolderService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val githubService: GithubService,
    private val githubUserDao: GithubUserDao
){
    fun getGithubUsers() = flow { emit(githubService.getGithubUsers()) }
}