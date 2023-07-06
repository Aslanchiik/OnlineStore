package com.example.data.remote.apiservices

import com.example.data.remote.dtos.CategoryModelDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CategoryApiService {

    @GET("products/categories")
    suspend fun fetchCategories(): Response<List<String>>

    @GET("products/category/{categoryId}")
    suspend fun fetchCategory(
        @Path("categoryId") id: String,
        @Query("sort") sort: String,
    ): List<CategoryModelDto>
}