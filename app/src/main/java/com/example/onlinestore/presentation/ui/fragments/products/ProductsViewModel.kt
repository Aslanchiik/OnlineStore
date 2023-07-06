package com.example.onlinestore.presentation.ui.fragments.products

import com.example.domain.usecases.ProductsUseCase
import com.example.onlinestore.base.BaseViewModel
import com.example.onlinestore.presentation.models.ProductsModelUI
import com.example.onlinestore.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase
) : BaseViewModel() {

    private val _productsState = MutableUIStateFlow<ProductsModelUI>()
    val productsState = _productsState.asStateFlow()

    fun fetchProducts(id: Int) {
        productsUseCase(id).collectUI(_productsState) {
            it?.toUI()
        }
    }
}