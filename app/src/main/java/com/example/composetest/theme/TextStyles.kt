package com.example.composetest.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composetest.R

object TextStyles {

    val H1 = TextStyle(
        fontSize = 48.sp,
        color = Color.DarkGray
    )

    val H2 = TextStyle(
        fontSize = 14.sp,
        color = Color.DarkGray
    )

    val CAPTION = TextStyle(
        fontSize = 12.sp,
        color = Color.DarkGray
    )
}

val TextStyle.Focus
    get() = this.plus(TextStyle(fontWeight = FontWeight.Bold))

val TextStyle.Light
    get() = this.plus(TextStyle(color = Color.White))

@Composable
fun TextStyle.Highlight() = this.plus(TextStyle(color = colorResource(id = R.color.color_primary)))