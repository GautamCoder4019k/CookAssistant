package com.example.recipefinder.data

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface FoodApiService {
    @GET("nosh-assignment")
    suspend fun getFood(): Response<List<FoodItem>>

}