package com.example.composetest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.R
import com.example.composetest.theme.Caption

@Preview
@Composable
fun HomeMenuPreview() {
    HomeMenu()
}

@Composable
fun HomeMenu() {
    Card(
        elevation = 4.dp,
        backgroundColor = colorResource(id = R.color.white),
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MenuListItem(
                painter = painterResource(id = R.drawable.ic_send_black_36),
                message = "Send"
            )
            MenuListItem(
                painter = painterResource(id = R.drawable.ic_card_giftcard_black_36),
                message = "Bills"
            )
            MenuListItem(
                painter = painterResource(id = R.drawable.ic_shopping_cart_black_36),
                message = "Shop"
            )
            MenuListItem(
                painter = painterResource(id = R.drawable.ic_document_scanner_black_36),
                message = "Scan"
            )
        }
    }
}

@Composable
fun MenuListItem(painter: Painter, message: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CardWithIcon(painter)
        Caption(text = message)
    }

}

@Composable
private fun CardWithIcon(painter: Painter) {
    Card(
        backgroundColor = colorResource(id = R.color.color_light_gray),
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .padding(bottom = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp),
                painter = painter,
                contentDescription = "@null",
                colorFilter = ColorFilter.tint(colorResource(id = R.color.color_primary_dark))
            )
        }
    }
}