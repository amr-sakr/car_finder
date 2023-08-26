package com.example.carfinder.di


import com.example.carfinder.data.repositories.CarsListRepository
import com.example.carfinder.data.repositories.ICarsListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RepositoriesModule {
    @Provides
    @Singleton
    fun provideCarsListRepository(repository: CarsListRepository): ICarsListRepository =
        repository

}
