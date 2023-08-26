package com.example.carfinder.di


import com.example.carfinder.data.api.CarsAPI
import com.example.carfinder.data.dataSource.IRemoteDataSource
import com.example.carfinder.data.dataSource.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Provides
    @Singleton
    fun bindIRemoteDataSource(
        carsAPI: CarsAPI,
        ): IRemoteDataSource {
        return RemoteDataSource(
            carsAPI
        )
    }

}
