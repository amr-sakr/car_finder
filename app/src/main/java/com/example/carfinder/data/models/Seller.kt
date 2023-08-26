package com.example.carfinder.data.models


import com.google.gson.annotations.SerializedName

data class Seller(
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("type")
    val type: String? = null
)