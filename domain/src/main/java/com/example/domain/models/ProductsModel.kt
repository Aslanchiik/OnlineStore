package com.example.domain.models

data class ProductsModel(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rate: RatingModel
)
