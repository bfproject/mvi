package com.architecture.data_repository.di

import com.architecture.core.repository.MarketRepository
import com.architecture.data_repository.MarketRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMarketRepository(marketRepository: MarketRepositoryImpl): MarketRepository

}
