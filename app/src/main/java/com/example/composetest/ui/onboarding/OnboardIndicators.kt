package com.example.composetest.ui.onboarding

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.R

@Preview(backgroundColor = 0xffffff, showBackground = true)
@Composable
fun PreviewIndicators() {
    Indicators(size = 4, index = 1)
}

@Composable
fun Indicators(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        repeat(size){
            IndicatorItem(isSelected = it == index)
        }
    }
}

@Composable
private fun IndicatorItem(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
    )

    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(color = getIndicatorColor(isSelected))
    )
}

@Composable
private fun getIndicatorColor(isSelected: Boolean): Color {
    return if (isSelected) colorResource(id = R.color.color_primary) else colorResource(id = R.color.color_light_gray)
}