package com.example.carfinder.data.dataSource

import com.example.carfinder.data.api.CarsAPI
import javax.inject.Inject

interface IRemoteDataSource {
    val carsAPI: CarsAPI
}


class RemoteDataSource @Inject constructor(
    override val carsAPI: CarsAPI
) : IRemoteDataSource