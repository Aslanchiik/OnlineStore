package com.example.domain.repositories

import com.example.domain.core.Resource
import com.example.domain.models.ProductsModel
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun fetchProducts(id: Int): Flow<Resource<ProductsModel>>
}