package com.example.recipefinder.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.recipefinder.data.FoodItem
import com.example.recipefinder.ui.components.commonComponents.HeadingText
import com.example.recipefinder.ui.components.commonComponents.RecommendedDishCard
import com.example.recipefinder.ui.theme.blue

@Composable
fun RecommendationSection(
    modifier: Modifier = Modifier,
    dishes: List<FoodItem>,
    onClicked: () -> Unit
) {
    var selectedItem by rememberSaveable { mutableStateOf(-1) }

    Column(
        modifier
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp)
    ) {
        HeadingText(
            text = "Recommendations",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 8.dp)
        )
        LazyRow {
            items(dishes) {
                RecommendedDishCard(
                    dishName = it.dishName,
                    imageUrl = it.imageUrl,
                    color = if (selectedItem == dishes.indexOf(it)) blue else Color.White,
                    onClick = {
                        selectedItem = dishes.indexOf(it)
                        onClicked()
                    },
                    modifier = Modifier.padding(12.dp)
                )
            }
        }

    }
}