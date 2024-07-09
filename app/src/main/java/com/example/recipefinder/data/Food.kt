package com.example.recipefinder.data

import kotlinx.serialization.Serializable

@Serializable
data class FoodItem(
    val dishName: String,
    val dishId: String,
    val imageUrl: String
)
