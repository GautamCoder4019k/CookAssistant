package com.example.recipefinder.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.recipefinder.R
import com.example.recipefinder.ui.components.commonComponents.ScheduledItemCard
import com.example.recipefinder.ui.theme.blue

@Composable
fun Header(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment =Alignment.CenterVertically
    ) {
        CustomSearchBar(
            modifier = Modifier
                .weight(6f)
                .padding(horizontal = 16.dp)
        )
        ScheduledItemCard(
            modifier = Modifier
                .weight(3f)
//                .padding(vertical = 8.dp, horizontal = 18.dp)
        )
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null,
            tint = blue,
            modifier = Modifier
                .weight(0.7f)
//                .padding(vertical = 40.dp)
                .size(36.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_power_settings_new_24),
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier
                .weight(0.7f)
//                .padding(vertical = 40.dp)
                .size(36.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(modifier: Modifier = Modifier) {
    SearchBar(
        inputField = {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = blue
                    )
                },
                placeholder = {
                    Text("Search for dish or ingredient", fontSize = 24.sp, color = Color.Gray)
                },
                shape = RoundedCornerShape(28.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = blue,
                    unfocusedBorderColor = blue
                ),
                modifier = Modifier.padding(0.dp)
            )
        },
        expanded = false,
        onExpandedChange = {},
        modifier = modifier.padding(0.dp)
    ) {
    }
}

@Composable
fun SmallRoundImage(model: Any, modifier: Modifier = Modifier) {
    AsyncImage(
        model = model,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
    )

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HeaderPreview() {
    Header()
}

