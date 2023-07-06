package com.example.data.remote.apiservices

import com.example.data.remote.dtos.ProductsModelDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {

    @GET("products/{id}")
    suspend fun fetchProducts(
        @Path("id") id: Int
    ): ProductsModelDto
}