package com.example.recipefinder.ui

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipefinder.data.FoodItem
import com.example.recipefinder.data.repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishViewModel @Inject constructor(private val repository: repository) : ViewModel() {

    private val _dishes = MutableStateFlow<List<FoodItem>>(emptyList())
    val dishes: StateFlow<List<FoodItem>> = _dishes

    init {
        getDishes()
    }

    fun getDishes() {
        viewModelScope.launch {
            val response = repository.getFood()
            _dishes.value = if (response.isSuccessful) {
                response.body() ?: emptyList()
            } else {
                emptyList()
            }
            Log.d(TAG, "getDishes: ${dishes.value}")
        }
    }

}