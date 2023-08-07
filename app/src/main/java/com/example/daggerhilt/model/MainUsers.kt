package com.example.daggerhilt.model

import com.example.daggerhilt.model.github.GithubUser

data class MainUsers(
    val jsonPlaseHolderUsers:List<UserData>,
    val githubUser: List<GithubUser>
)