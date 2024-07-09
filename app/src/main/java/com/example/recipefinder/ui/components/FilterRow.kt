package com.example.recipefinder.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipefinder.ui.components.commonComponents.FilterChip
import com.example.recipefinder.ui.components.commonComponents.HeadingText

@Composable
fun FilterRow(modifier: Modifier = Modifier) {
    Column(modifier.padding(horizontal = 16.dp)) {
        HeadingText(
            text = "Whats on your mind?",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 8.dp)
        )
        LazyRow {
            item {
                FilterChip(
                    text = "Rice items",
                    imageUrl = "https://nosh-assignment.s3.ap-south-1.amazonaws.com/jeera-rice.jpg",
                    modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            item {
                FilterChip(
                    text = "Indian",
                    imageUrl = "https://nosh-assignment.s3.ap-south-1.amazonaws.com/paneer-tikka.jpg",
                    modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            item {
                FilterChip(
                    text = "Curries",
                    imageUrl = "https://nosh-assignment.s3.ap-south-1.amazonaws.com/rabdi.jpg",
                    modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            item {
                FilterChip(
                    text = "Soups",
                    imageUrl = "https://nosh-assignment.s3.ap-south-1.amazonaws.com/chicken-biryani.jpg",
                    modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            item {
                FilterChip(
                    text = "Desserts",
                    imageUrl = "https://nosh-assignment.s3.ap-south-1.amazonaws.com/alfredo-pasta.jpg",
                    modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
            item {
                FilterChip(
                    text = "Snacks",
                    imageUrl = "https://nosh-assignment.s3.ap-south-1.amazonaws.com/alfredo-pasta.jpg",
                    modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }

    }
}



