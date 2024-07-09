package com.example.recipefinder.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipefinder.R
import com.example.recipefinder.ui.theme.blue
import com.example.recipefinder.ui.theme.orange
import com.example.recipefinder.ui.theme.screenBg

@Composable
fun NavigationRail() {
    var selectedItem by rememberSaveable { mutableStateOf(AppDestinations.COOK) }
    val selectedIndex = AppDestinations.entries.indexOf(selectedItem)
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(150.dp)
            .background(White), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxSize()
                .padding(vertical = 16.dp)
                .background(White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppDestinations.entries.forEach {
                val selected = selectedItem == it
                if (it.icon != null)
                    NavigationItem(
                        label = it.label,
                        icon = it.icon,
                        onItemClick = { selectedItem = it },
                        color = if (selected) orange else blue
                    )
                else if (it.iconRes != null)
                    NavigationItem(
                        label = it.label,
                        iconRes = it.iconRes,
                        color = if (selected) orange else blue,
                        onItemClick = { selectedItem = it })
            }

        }

    }
    Box(contentAlignment = Alignment.CenterEnd) {
        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
            selectedIndex = selectedIndex + 1,
            itemCount = AppDestinations.entries.size + 10
        )
    }
}


@Composable
fun NavigationItem(
    icon: ImageVector? = null,
    iconRes: Int? = null,
    label: String,
    color: Color = blue,
    onItemClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                onItemClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (icon != null)
            Icon(
                icon,
                contentDescription = label,
                tint = color,
                modifier = Modifier.size(40.dp)
            )
        else if (iconRes != null)
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                tint = color,
                modifier = Modifier.size(40.dp)
            )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = label, color = color, fontSize = 18.sp)
    }
}

@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    itemCount: Int
) {
    Canvas(modifier = modifier) {
        val totalHeight = size.height
        val itemHeight = (totalHeight) / (itemCount)
        val bulgeHeight = 36.dp.toPx()
        val bulgeWidth = 40.dp.toPx()
        val selectedCenterY =
            if (selectedIndex == 1 || selectedIndex == 2) ((itemHeight * selectedIndex + itemHeight / 2) * 2) - (itemHeight / 2)
            else (itemHeight * selectedIndex + itemHeight / 2) * 2
        val dividerX = size.width - 5f // Right side of the navigation rail

        val paint = Paint().apply {
            color = screenBg
            isAntiAlias = true
            asFrameworkPaint().apply {
                setShadowLayer(3.dp.toPx(), 5f, 0f, android.graphics.Color.BLACK)
            }
        }

        val dividerX1 = size.width - 5f // Adjust the position of the line as needed

        drawIntoCanvas { canvas ->
            canvas.drawLine(
                Offset(x = dividerX1, y = 0f),
                Offset(x = dividerX1, y = size.height),
                paint
            )
        }

        // Draw the bulge
        val path = Path().apply {
            moveTo(dividerX, selectedCenterY - bulgeHeight / 2)
            cubicTo(
                -(dividerX - bulgeWidth / 2), selectedCenterY - bulgeHeight / 4,
                -(dividerX - bulgeWidth / 2), selectedCenterY + bulgeHeight / 4,
                dividerX, selectedCenterY + bulgeHeight / 2
            )

            close()
        }

        drawPath(
            path = path,
            color = White,
            style = Fill
        )

        // Draw the small circle
        drawCircle(
            color = Color(0xFFFFA500),
            radius = 6.dp.toPx(),
            center = Offset(dividerX, selectedCenterY)
        )
    }
}

enum class AppDestinations(
    val icon: ImageVector? = null,
    val iconRes: Int? = null,
    val label: String,
) {
    COOK(iconRes = R.drawable.cook_icon, label = "Cook"),
    FAVOURITES(icon = Icons.Outlined.FavoriteBorder, label = "Favourites"),
    MANUAL(iconRes = R.drawable.manual_icon, label = "Manual"),
    DEVICE(iconRes = R.drawable.device_icon, label = "Device"),
    PREFERENCES(Icons.Outlined.AccountCircle, label = "Preferences"),
    SETTINGS(Icons.Outlined.Settings, label = "Settings"),
}

