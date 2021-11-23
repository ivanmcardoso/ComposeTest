package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetest.ui.mainscreen.MainScreen
import com.example.composetest.ui.onboarding.OnboardScreen
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavSetup()
        }
    }

    @ExperimentalPagerApi
    @ExperimentalFoundationApi
    @Composable
    fun NavSetup() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = RouterPaths.ROUTER_HOME,
            builder = {
                composable(RouterPaths.ROUTER_HOME, content = { MainScreen(navController) })
                composable(RouterPaths.ROUTER_ONBOARD, content = { OnboardScreen()})
            })
    }

    object RouterPaths {
        const val ROUTER_HOME = "router_home"
        const val ROUTER_ONBOARD = "router_onboard"
    }
}
