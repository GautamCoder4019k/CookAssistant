package com.example.recipefinder.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.commandiron.wheel_picker_compose.WheelTimePicker
import com.commandiron.wheel_picker_compose.core.TimeFormat
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import com.example.recipefinder.ui.components.commonComponents.shadow
import com.example.recipefinder.ui.theme.blue
import com.example.recipefinder.ui.theme.lightOrange
import com.example.recipefinder.ui.theme.lightOrange1
import com.example.recipefinder.ui.theme.timePicker
import kotlinx.coroutines.launch
import java.time.LocalTime


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleCookingTimeContent(onClose: () -> Unit) {
    var selectedTime by remember { mutableStateOf("AM") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Schedule cooking time",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = blue
            )
            Icon(
                Icons.Default.Close,
                contentDescription = "Close",
                Modifier
                    .clip(CircleShape)
                    .background(timePicker)
                    .padding(12.dp)
                    .size(36.dp)

                    .clickable { onClose() })
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 64.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(timePicker)
                    .padding(horizontal = 24.dp)
            ) {
                WheelTimePicker(
                    timeFormat = TimeFormat.HOUR_24,
                    modifier = Modifier.background(timePicker),
                    size = DpSize(250.dp, 250.dp),
                    textStyle = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = blue
                    ),
                    textColor = blue,
                    selectorProperties = WheelPickerDefaults.selectorProperties(
                        border = null,
                        enabled = false
                    )
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.height(200.dp)
            ) {
                TextButton(
                    onClick = { selectedTime = "AM" },
                    colors = ButtonDefaults.textButtonColors(containerColor = if (selectedTime == "AM") blue else timePicker),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(
                        text = "AM",
                        color = if (selectedTime == "AM") Color.White else blue,
                        fontSize = 24.sp
                    )
                }
                TextButton(
                    onClick = { selectedTime = "PM" },
                    colors = ButtonDefaults.textButtonColors(containerColor = if (selectedTime == "PM") blue else timePicker),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "PM",
                        color = if (selectedTime == "PM") Color.White else blue,
                        fontSize = 24.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { /* handle delete */ }) {
                Text(
                    "Delete",
                    color = Color.Red,
                    fontSize = 24.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
            OutlinedButton(
                onClick = { /* handle re-schedule */ },
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White),
                border = ButtonDefaults.outlinedButtonBorder(),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.shadow(
                    color = lightOrange,
                    offsetX = 8.dp,
                    offsetY = 8.dp,
                    blurRadius = 12.dp,
                    cornerRadius = 12.dp
                ),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 24.dp)
            ) {
                Text("Re-schedule", color = lightOrange, fontSize = 24.sp)
            }
            Button(
                onClick = { /* handle cook now */ },
                colors = ButtonDefaults.buttonColors(containerColor = lightOrange1),
                shape = RoundedCornerShape(12.dp),
                contentPadding = PaddingValues(vertical = 24.dp, horizontal = 36.dp)
            ) {
                Text("Cook Now", fontSize = 24.sp)
            }
        }
    }
}
