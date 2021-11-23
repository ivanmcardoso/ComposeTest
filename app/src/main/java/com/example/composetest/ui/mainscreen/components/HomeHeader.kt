package com.example.composetest.ui.mainscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composetest.R
import com.example.composetest.theme.Caption
import com.example.composetest.theme.Title2

@Composable
fun Header(name: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileImage(painter = painterResource(id = R.drawable.ic_avatar_placeholder_small))
            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                Title2.Light(text = "Hi there, $name")
                Caption.Light(text = "Welcome back to RE - NEO")
            }
        }
        NotificationImage()
    }
}

@Composable
fun ProfileImage(painter: Painter) = Image(
    painter = painter,
    contentDescription = "Placeholder",
    modifier = Modifier.clip(CircleShape),
    colorFilter = ColorFilter.tint(Color.White)
)

@Composable
fun NotificationImage() =
    Image(
        painter = painterResource(id = R.drawable.ic_notification_24),
        contentDescription = "Icone de notificação",
        colorFilter = ColorFilter.tint(Color.White)
    )