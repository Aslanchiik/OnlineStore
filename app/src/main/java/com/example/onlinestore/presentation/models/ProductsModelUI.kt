package com.example.onlinestore.presentation.models

import com.example.domain.models.ProductsModel
import com.example.domain.models.RatingModel

data class ProductsModelUI(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rateModel: RatingModelUI
)

fun ProductsModel.toUI() = ProductsModelUI(
    id, title, price, description, category, image, rate.toUI()
)

data class RatingModelUI(
    val rate: Double,
    val count: Int
)

fun RatingModel.toUI() = RatingModelUI(
    rate, count
)


