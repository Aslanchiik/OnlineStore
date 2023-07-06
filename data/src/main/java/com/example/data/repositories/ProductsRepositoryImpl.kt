package com.example.data.repositories

import com.example.data.base.BaseRepository
import com.example.data.remote.apiservices.ProductApiService
import com.example.domain.repositories.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productApiService: ProductApiService
) : BaseRepository(), ProductsRepository {

    override fun fetchProducts(id: Int) = doRequest {
        productApiService.fetchProducts(id).mapToDomain()
    }
}