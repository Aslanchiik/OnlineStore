package com.example.onlinestore.presentation.models

import com.example.domain.models.CategoryModel
import com.example.onlinestore.base.IBaseDiffModel

data class CategoryModelUI(
    override val id: Int,
    val title: String?,
    val price: Double?,
    val image: String,
) : IBaseDiffModel<Int>

fun CategoryModel.toUI() = CategoryModelUI(
    id, title, price, image
)
