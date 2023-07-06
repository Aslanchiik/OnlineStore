package com.example.data.remote

import com.example.data.remote.apiservices.CategoryApiService
import com.example.data.remote.apiservices.ProductApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val provideRetrofitClient = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCategoryApiService(): CategoryApiService = provideRetrofitClient
        .create(CategoryApiService::class.java)

    fun provideProductsApiService(): ProductApiService = provideRetrofitClient.create(
        ProductApiService::class.java
    )
}