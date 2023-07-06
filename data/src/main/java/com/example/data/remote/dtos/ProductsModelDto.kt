package com.example.data.remote.dtos

import com.example.data.utils.DataMapper
import com.example.domain.models.ProductsModel
import com.google.gson.annotations.SerializedName

data class ProductsModelDto(

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("price")
    val price: Double,

    @SerializedName("description")
    val description: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("rating")
    val rateModelDto: RatingModelDto
) : DataMapper<ProductsModel> {
    override fun mapToDomain() = ProductsModel(
        id, title, price, description, category, image, rateModelDto.mapToDomain()
    )
}
