package com.example.daggerhilt.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daggerhilt.model.github.GithubUser

@Dao
interface GithubUserDao {

    @Insert(onConflict = OnConflictStrategy. REPLACE)
    fun addGitgubeUsers(list:List<GithubUser>)


    @Query("select * from githubuserentity")
    fun getGitgubUsers():List<GithubUser>
}