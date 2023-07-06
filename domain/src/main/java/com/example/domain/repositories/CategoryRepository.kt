package com.example.domain.repositories

import com.example.domain.core.Resource
import com.example.domain.models.CategoryModel
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun fetchCategories(): Flow<Resource<List<String>>>

    fun fetchCategory(id: String, sort: String): Flow<Resource<List<CategoryModel>>>
}