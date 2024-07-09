package com.example.recipefinder.ui.components.commonComponents

import android.annotation.SuppressLint
import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@SuppressLint("SuspiciousModifierThen")
fun Modifier.shadow(
    color: Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    cornerRadius: Dp = 36.dp,
) = this.then(
    Modifier.drawBehind {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter =
                    BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL)
            }
            frameworkPaint.color = color.toArgb()

            val shadowPath = Path().apply {
                addRoundRect(
                    roundRect = RoundRect(
                        offsetX.toPx(),
                        offsetY.toPx(),
                        size.width + offsetX.toPx() / 2,
                        size.height + offsetY.toPx() / 2,
                        CornerRadius(cornerRadius.toPx())
                    ),
                    Path.Direction.Clockwise
                )
            }

            canvas.drawPath(shadowPath, paint)
        }
    }
)