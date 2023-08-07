package com.example.daggerhilt.di.module

import android.content.Context
import androidx.room.Room
import com.example.daggerhilt.database.AppDatabase
import com.example.daggerhilt.database.dao.GithubUserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context:Context):AppDatabase{
        return Room.databaseBuilder(context, AppDatabase::class.java, "my_db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideGityhubUserDao(appDatabase: AppDatabase):GithubUserDao{
        return appDatabase.getGithubUserDao()
    }
}