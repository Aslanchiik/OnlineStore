package com.example.domain.usecases

import com.example.domain.repositories.CategoryRepository
import javax.inject.Inject

class CategoryDetailUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    operator fun invoke(id: String, sort: String) = categoryRepository.fetchCategory(id, sort)
}