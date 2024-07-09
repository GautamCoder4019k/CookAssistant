package com.example.recipefinder.ui.components.commonComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.recipefinder.R
import com.example.recipefinder.ui.components.SmallRoundImage
import com.example.recipefinder.ui.theme.black
import com.example.recipefinder.ui.theme.blue
import com.example.recipefinder.ui.theme.cardColor
import com.example.recipefinder.ui.theme.cardLight
import com.example.recipefinder.ui.theme.lightOrange
import com.example.recipefinder.ui.theme.lightOrange1

@Composable
fun ScheduledItemCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(14.dp).width(50.dp),
        shape = RoundedCornerShape(36.dp),
        colors = CardDefaults.cardColors(containerColor = black)
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            SmallRoundImage(
                model = "https://nosh-assignment.s3.ap-south-1.amazonaws.com/alfredo-pasta.jpg",
                modifier = Modifier.padding(4.dp)
            )
            Spacer(modifier = Modifier.width(18.dp))
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Italian Spaghetti",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Justify,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = "Scheduled 6:30 AM", color = Color.White, fontSize = 14.sp)
            }
        }

    }
}

@Composable
fun FilterChip(text: String, imageUrl: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .shadow(
                color = lightOrange,
                offsetX = 12.dp,
                offsetY = 12.dp,
                blurRadius = 12.dp
            )
            .clip(RoundedCornerShape(36.dp)),
        shape = RoundedCornerShape(36.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 4.dp)
                .padding(end = 8.dp)
        ) {
            SmallRoundImage(model = imageUrl)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                color = blue,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendedDishCard(
    modifier: Modifier = Modifier,
    dishName: String = "Italian Spaghetti",
    imageUrl: String = "https://nosh-assignment.s3.ap-south-1.amazonaws.com/alfredo-pasta.jpg",
    color: Color = Color.White,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .width(232.dp)
            .shadow(
                color = lightOrange,
                offsetX = 12.dp,
                offsetY = 12.dp,
                blurRadius = 12.dp,
                cornerRadius = 24.dp
            )
            .clip(RoundedCornerShape(24.dp))
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = color),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(cardColor)
                        .padding(horizontal = 32.dp, vertical = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(150.dp)
                    )
                }
                Icon(
                    painter = painterResource(R.drawable.non_veg),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopEnd)
                        .size(24.dp),
                    tint = Color.Red

                )

                IconWithText(
                    text = "4.2",
                    modifier = Modifier
                        .clip(RoundedCornerShape(18.dp))
                        .background(lightOrange1)
                        .padding(horizontal = 8.dp)
                        .align(Alignment.BottomCenter),
                    color = Color.White,
                    icon = R.drawable.star
                )
            }
            Text(
                text = dishName,
                color = if (color != blue) blue else Color.White,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                fontSize = 22.sp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 8.dp)
            )
            Row(modifier = Modifier.padding(bottom = 10.dp)) {
                IconWithText(
                    text = "30 min",
                    color = if (color == Color.White) Color.Black else cardLight
                )
                Text(
                    text = " · Medium prep.",
                    fontWeight = FontWeight.Medium,
                    color = if (color == Color.White) Color.Black else cardLight
                )
            }
        }
    }
}

@Preview
@Composable
fun FooterCard(
    modifier: Modifier = Modifier,
    text: String = "Explore all dishes",
    imageRes: Int? = null
) {
    Card(
        modifier = Modifier
            .height(height = 60.dp)
            .width(width = 450.dp)
            .clickable {},
        colors = CardDefaults.cardColors(containerColor = lightOrange1),
        shape = RoundedCornerShape(18.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp)
        ) {
            Text(
                text = text,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp)
                    .weight(1f)
            )
            if (imageRes != null)
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.weight(1f)
                )
        }
    }
}

