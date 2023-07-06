package com.example.data.remote.dtos

import com.example.data.utils.DataMapper
import com.example.domain.models.RatingModel
import com.google.gson.annotations.SerializedName

data class RatingModelDto(

    @SerializedName("rate")
    val rate: Double,

    @SerializedName("count")
    val count: Int
) : DataMapper<RatingModel> {
    override fun mapToDomain() = RatingModel(rate, count)
}
