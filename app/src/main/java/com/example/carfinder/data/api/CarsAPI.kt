package com.example.carfinder.data.api

import com.example.carfinder.BuildConfig
import com.example.carfinder.data.models.UsedCarsResponse
import retrofit2.Response
import retrofit2.http.GET

interface CarsAPI {

    @GET(BuildConfig.BASE_URL)
    suspend fun getCarsList(
    ): Response<UsedCarsResponse>
}