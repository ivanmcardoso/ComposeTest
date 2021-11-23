package com.example.composetest.ui.mainscreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.composetest.R
import com.example.composetest.data.model.CardInfo
import com.example.composetest.theme.Caption
import com.example.composetest.theme.Title1
import com.example.composetest.theme.Title2

class CardInfoPreviewParameterProvider : PreviewParameterProvider<CardInfo> {
    override val values = sequenceOf(
        CardInfo("Elise","50.000,00", "**** **** **** 1234", "12/25")
    )
}

@Preview
@Composable
fun PreviewCard(@PreviewParameter(CardInfoPreviewParameterProvider::class, limit = 1) cardInfo: CardInfo) {
    CardListITem(cardInfo = cardInfo)
}

@Composable
fun CardListITem(cardInfo: CardInfo) {
    Card(
        backgroundColor = colorResource(id = R.color.purple_200),
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Title2.Light(text = cardInfo.name)
            Title1.Light(text = "R$ ${cardInfo.balance}")
            Caption.Light(text = cardInfo.number)
            Caption.Light(text = cardInfo.expirationDate)
        }
    }
}