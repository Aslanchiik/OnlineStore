package com.example.onlinestore.di

import com.example.data.remote.RetrofitClient
import com.example.data.remote.apiservices.CategoryApiService
import com.example.data.remote.apiservices.ProductApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideCategories(): CategoryApiService {
        return retrofitClient.provideCategoryApiService()
    }

    @Singleton
    @Provides
    fun provideProducts(): ProductApiService {
        return retrofitClient.provideProductsApiService()
    }
}