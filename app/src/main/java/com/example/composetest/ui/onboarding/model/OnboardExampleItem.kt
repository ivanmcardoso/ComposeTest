package com.example.composetest.ui.onboarding.model

import androidx.annotation.DrawableRes
import com.example.composetest.R

data class OnboardExampleItem(
    val title: String,
    @DrawableRes val image: Int,
    val text: String
) {

    companion object {
        fun genericList() = listOf(
            OnboardExampleItem(
                title = "the title 1",
                image = R.drawable.onboard_1,
                text = "text 1"
            ),OnboardExampleItem(
                title = "the title 2",
                image = R.drawable.onboard_2,
                text = "text 2"
            ),OnboardExampleItem(
                title = "the title 2",
                image = R.drawable.onboord_3,
                text = "text 2"
            )
        )
    }
}