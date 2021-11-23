package com.example.composetest.data

import com.example.composetest.data.model.CardInfo

class CardRepository {

    fun getUserName() = "Ivan"

    fun getCardList() = listOf(
        CardInfo(
            name = "Visa",
            balance = "50,000.00",
            number = "***** **** **** 1234",
            expirationDate = "12/24"
        ),
        CardInfo(
            name = "Visa",
            balance = "25,000.00",
            number = "***** **** **** 5678",
            expirationDate = "13/25"
        ),
        CardInfo(
            name = "Visa",
            balance = "500.00",
            number = "***** **** **** 9123",
            expirationDate = "10/22"
        )
    )
}