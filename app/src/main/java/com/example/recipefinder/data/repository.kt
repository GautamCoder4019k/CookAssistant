package com.example.recipefinder.data

import javax.inject.Inject

class repository @Inject constructor(private val foodApiService: FoodApiService) {

    suspend fun getFood() = foodApiService.getFood()
}