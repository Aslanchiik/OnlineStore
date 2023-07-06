package com.example.data.remote.dtos

import com.example.data.utils.DataMapper
import com.example.domain.models.CategoryModel
import com.google.gson.annotations.SerializedName

data class CategoryModelDto(

    @SerializedName("id") val id: Int,

    @SerializedName("title") val title: String?,

    @SerializedName("price")
    val price: Double?,

    @SerializedName("image")
    val image: String,
) : DataMapper<CategoryModel> {
    override fun mapToDomain() = CategoryModel(
        id, title, price, image
    )
}

