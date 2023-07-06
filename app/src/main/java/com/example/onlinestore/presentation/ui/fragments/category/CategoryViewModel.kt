package com.example.onlinestore.presentation.ui.fragments.category

import com.example.domain.usecases.CategoryUseCase
import com.example.onlinestore.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase
) : BaseViewModel() {

    private val _categoriesState = MutableUIStateFlow<List<String>>()
    val categoriesState = _categoriesState.asStateFlow()

    init {
        fetchCategories()
    }

    fun fetchCategories() {
        categoryUseCase().collectUI(_categoriesState) {
            it
        }
    }
}