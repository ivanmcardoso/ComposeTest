package com.example.composetest.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.R
import com.example.composetest.theme.Caption
import com.example.composetest.theme.Title1
import com.example.composetest.theme.Title2

@Preview
@Composable
fun PreviewCard() {
    CardListITem()
}

@Composable
fun CardListITem() {
    Card(
        backgroundColor = colorResource(id = R.color.purple_200),
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Title2.Light(text = "Visa Balance")
            Title1.Light(text = "R$ 50.000,00")
            Caption.Light(text = "**** **** **** 1234")
            Caption.Light(text = "12/24")
        }
    }
}