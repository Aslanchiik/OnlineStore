package com.example.domain.usecases

import com.example.domain.repositories.ProductsRepository
import javax.inject.Inject

class ProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    operator fun invoke(id: Int) = productsRepository.fetchProducts(id)
}