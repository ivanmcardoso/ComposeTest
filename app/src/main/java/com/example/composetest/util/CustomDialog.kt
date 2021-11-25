package com.example.composetest.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.composetest.R
import com.example.composetest.theme.Caption
import com.example.composetest.theme.Title1
import com.example.composetest.theme.Title2

@Preview
@Composable
fun PreviewCustomDialog() {
    CustomDialogCard(
        title = "Sed ut perspicia unde omnis is",
        message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim.",
        "Entendi",
        {},
        {})
}

@Composable
fun CustomDialog(
    title: String,
    message: String,
    buttonText: String,
    onButtonClick: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        CustomDialogCard(title, message, buttonText, onButtonClick, onDismiss)
    }
}

@Composable
private fun CustomDialogCard(
    title: String,
    message: String,
    buttonText: String,
    onButtonClick: () -> Unit,
    onDismiss: () -> Unit
) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier.weight(1f)){
                    Title1.Focus(text = title)
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_close_24),
                    contentDescription = "close",
                    tint = colorResource(id = R.color.color_primary),
                    modifier = Modifier
                        .clickable { onDismiss() }
                )

            }
            Caption(message)
            Button(
                onClick = onButtonClick,
                shape = RoundedCornerShape(100.dp),
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ) {
                Caption.Light(text = buttonText)
            }
        }
    }
}