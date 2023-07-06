package com.example.domain.usecases

import com.example.domain.repositories.CategoryRepository
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    operator fun invoke() = categoryRepository.fetchCategories()
}