package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composetest.ui.mainscreen.MainScreenViewModel
import com.example.composetest.ui.onboarding.OnboardScreen
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MainScreenViewModel()
        setContent {
//            MainScreen(viewModel)
            OnboardScreen()
        }
    }
}
