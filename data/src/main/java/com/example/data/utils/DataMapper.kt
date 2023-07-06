package com.example.data.utils

interface DataMapper<T> {

    /**
     * Function for map data layer model to domain layer model
     */
    fun mapToDomain(): T
}