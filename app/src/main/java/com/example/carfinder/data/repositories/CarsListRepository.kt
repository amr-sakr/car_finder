package com.example.carfinder.data.repositories

import com.example.carfinder.data.dataSource.IRemoteDataSource
import com.example.carfinder.data.models.UsedCarsResponse
import com.example.carfinder.di.IoDispatcher
import com.example.carfinder.utils.NetworkUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

interface ICarsListRepository {
    suspend fun getCarsList(): Flow<UsedCarsResponse>
}

@Singleton
class CarsListRepository @Inject constructor(
    private val networkUtils: NetworkUtils,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val remoteDataSource: IRemoteDataSource
) : ICarsListRepository {
    override suspend fun getCarsList() = flow {
        try {
            if (!networkUtils.isConnectedToNetwork())
                throw IOException("Please Check your Internet connection")

            emit(
                with(remoteDataSource.carsAPI.getCarsList()) {
                    if (isSuccessful) body()!!
                    else throw IOException("Something went wrong, Please try again later")
                }
            )
        } catch (throwable: Throwable) {
            throw throwable
        }
    }.flowOn(ioDispatcher)

}





