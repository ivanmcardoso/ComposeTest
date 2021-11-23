package com.example.composetest.ui.mainscreen

import android.os.Handler
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composetest.data.CardRepository
import com.example.composetest.data.model.CardInfo

class MainScreenViewModel(
    private val cardRepository: CardRepository = CardRepository()
) : ViewModel() {

    val cardList = mutableStateOf<List<CardInfo>>(arrayListOf())
    val userName = mutableStateOf(cardRepository.getUserName())

    fun loadCardList() {
        Handler().postDelayed({
            cardList.value = cardRepository.getCardList()
        }, 1000)
    }
}