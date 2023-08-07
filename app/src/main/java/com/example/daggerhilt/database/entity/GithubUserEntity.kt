package com.example.daggerhilt.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GithubUserEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val avatar:String,
    val login:String
)