package com.example.onlinestore.di

import com.example.data.repositories.CategoryRepositoryImpl
import com.example.data.repositories.ProductsRepositoryImpl
import com.example.domain.repositories.CategoryRepository
import com.example.domain.repositories.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModules {

    @Binds
    abstract fun bindCategoryRepository(repositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    abstract fun bindProductsRepository(productsRepositoryImpl: ProductsRepositoryImpl): ProductsRepository

}