package com.example.composetest.theme

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

open class TextTypes(private val textStyle: TextStyle) {
    @Composable
    operator fun invoke(text: String) = Text(text = text, style = textStyle)

    @Composable
    fun Focus(text: String) = Text(text = text, style = textStyle.Focus)

    @Composable
    fun FocusLight(text: String) = Text(text = text, style = textStyle.Focus.Light)

    @Composable
    fun FocusHighlight(text: String) = Text(text = text, style = textStyle.Focus.Highlight())

    @Composable
    fun Light(text: String) = Text(text = text, style = textStyle.Light)

    @Composable
    fun Highlight(text: String) = Text(text = text, style = textStyle.Highlight())
}