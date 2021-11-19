package com.example.composetest.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.composetest.R
import com.example.composetest.ui.components.CardListITem
import com.example.composetest.ui.components.Header
import com.example.composetest.ui.components.HomeMenu

@Preview
@Composable
fun PreviewHeader() {
    MainScreen()
}

@Composable
fun MainScreen() {
    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            ConstraintLayout(constraintSet) {
                BackgroundView()
                CardHeader()
                AnchorView()
                Menu()
            }
        }
    }
}

@Composable
private fun BackgroundView() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId(LayoutIds.SURFACE_ID),
        color = colorResource(id = R.color.color_primary)
    ) { }
}

@Composable
private fun CardHeader() {
    Column(
        Modifier
            .padding(vertical = 20.dp)
            .layoutId(LayoutIds.CARDS_ID)
    ) {
        Header(name = "Ivan")
        CardList {
            items(listOf("a", "b", "c")) {
                CardListITem()
            }
        }
    }
}

@Composable
private fun AnchorView() {
    Spacer(
        Modifier
            .height(0.dp)
            .layoutId(LayoutIds.ANCHOR_ID)
    )
}

@Composable
private fun Menu() {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .layoutId(LayoutIds.MENU_ID)
    ) {
        HomeMenu()
    }
}

@Composable
private fun CardList(content: LazyListScope.() -> Unit) = LazyRow(
    content = content,
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp),
    contentPadding = PaddingValues(horizontal = 20.dp),
    horizontalArrangement = Arrangement.spacedBy(12.dp)
)

private val constraintSet = ConstraintSet {
    val surfaceRef = createRefFor(LayoutIds.SURFACE_ID)
    val cardsRef = createRefFor(LayoutIds.CARDS_ID)
    val anchorViewRef = createRefFor(LayoutIds.ANCHOR_ID)
    val menuRef = createRefFor(LayoutIds.MENU_ID)
    constrain(surfaceRef) {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        bottom.linkTo(anchorViewRef.top)
        height = Dimension.fillToConstraints
    }
    constrain(cardsRef) {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
    }
    constrain(anchorViewRef) {
        top.linkTo(menuRef.top)
        bottom.linkTo(menuRef.bottom)
    }
    constrain(menuRef) {
        top.linkTo(cardsRef.bottom)
        start.linkTo(parent.start)
    }
}

private object LayoutIds {
    const val SURFACE_ID = "surface_id"
    const val ANCHOR_ID = "anchor_id"
    const val CARDS_ID = "cards_id"
    const val MENU_ID = "menu_id"
}