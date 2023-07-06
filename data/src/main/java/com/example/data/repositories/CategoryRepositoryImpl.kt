package com.example.data.repositories

import com.example.data.base.BaseRepository
import com.example.data.remote.apiservices.CategoryApiService
import com.example.domain.repositories.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryApiService: CategoryApiService
) : BaseRepository(), CategoryRepository {

    override fun fetchCategories() = doRequests({
        categoryApiService.fetchCategories()
    }) {
        it
    }

    override fun fetchCategory(id: String, sort: String) = doRequest {
        categoryApiService.fetchCategory(id, sort).map {
            it.mapToDomain()
        }
    }
}