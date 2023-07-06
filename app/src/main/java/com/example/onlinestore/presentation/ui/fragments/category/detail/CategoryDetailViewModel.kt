package com.example.onlinestore.presentation.ui.fragments.category.detail

import com.example.domain.usecases.CategoryDetailUseCase
import com.example.onlinestore.base.BaseViewModel
import com.example.onlinestore.presentation.models.CategoryModelUI
import com.example.onlinestore.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val categoryDetailUseCase: CategoryDetailUseCase
) : BaseViewModel() {

    private val _categoryState = MutableUIStateFlow<List<CategoryModelUI>>()
    val categoryState = _categoryState.asStateFlow()

    fun fetchCategoryId(id: String, sort: String) {
        categoryDetailUseCase(id, sort).collectUI(_categoryState) { category ->
            category?.map { it.toUI() }
        }
    }
}