package com.example.daggerhilt.di.module

import com.example.daggerhilt.networking.GithubService
import com.example.daggerhilt.networking.JsonPlaseHolderService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    @Named(value = "jsonplaceholder") // Agar BaseUrl 2ta bolsa shunde Named dan foydalaniladi
    fun provideJsonPlaseHolderBaseUrl(): String = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    @Named(value = "github")
    fun provideGithubBaseUrl(): String = "https://api.github.com/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun providerConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    @Named("retrofit1")
    fun provideRetrofit(
        @Named("jsonplaceholder") baseUrl: String,
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    @Named("retrofit2")
    fun provideGithubRetrofit(
        @Named("github") baseUrl: String,
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideJsonPlaseHolder(@Named("retrofit1") retrofit: Retrofit): JsonPlaseHolderService {
        return retrofit.create(JsonPlaseHolderService::class.java)
    }

    @Provides
    @Singleton
    fun providGithub(@Named("retrofit2") retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)

    }
}