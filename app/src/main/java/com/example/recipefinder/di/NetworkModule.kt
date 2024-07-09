package com.example.recipefinder.di

import com.example.recipefinder.data.FoodApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideFoodApiService(): FoodApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://fls8oe8xp7.execute-api.ap-south-1.amazonaws.com/dev/")
            .build()
            .create(FoodApiService::class.java)
    }
}