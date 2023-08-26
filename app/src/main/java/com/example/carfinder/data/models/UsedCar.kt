package com.example.carfinder.data.models


import com.google.gson.annotations.SerializedName

data class UsedCar(
    @SerializedName("colour")
    val colour: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("firstRegistration")
    val firstRegistration: String? = null,
    @SerializedName("fuel")
    val fuel: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("images")
    val images: List<Image>? = null,
    @SerializedName("make")
    val make: String? = null,
    @SerializedName("mileage")
    val mileage: Int? = null,
    @SerializedName("model")
    val model: String? = null,
    @SerializedName("modelline")
    val modelline: String? = null,
    @SerializedName("price")
    val price: Int? = null,
    @SerializedName("seller")
    val seller: Seller? = null
)