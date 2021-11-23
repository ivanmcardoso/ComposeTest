package com.example.composetest.ui.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.R
import com.example.composetest.theme.Title1
import com.example.composetest.theme.Title2
import com.example.composetest.ui.onboarding.model.OnboardExampleItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Preview
@Composable
fun OnboardScreenPreview() {
    OnboardScreen()
}

@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun OnboardScreen() {

    val items = OnboardExampleItem.genericList()
    val pagerState = rememberPagerState(initialPage = 0)
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.background(color = Color.White)) {
        Column {
            OverScrollerNerver {
                HorizontalPager(
                    count = items.size,
                    state = pagerState,
                    modifier = Modifier.weight(1f)
                ) { page ->
                    OnboardItem(item = items[page])
                }
            }

            OnboardFooter(size = items.size, index = pagerState.currentPage) {
                // Como tira isso daqui ? (de vez em quando trava ( '-'))
                scope.launch {
                    if (pagerState.currentPage + 1 < items.size){
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    } else {
                        snackbarHostState.showSnackbar("Acabou !", duration = SnackbarDuration.Short, actionLabel = "Entendi")
                    }
                }
            }
        }
        SnackbarHost(hostState = snackbarHostState, modifier = Modifier.align(Alignment.BottomCenter))

    }

}

@ExperimentalFoundationApi
@Composable
private fun OverScrollerNerver(content: @Composable ()->Unit) = CompositionLocalProvider(
    LocalOverScrollConfiguration provides null
) {
    content()
}

@Composable
private fun OnboardItem(item: OnboardExampleItem) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title1.FocusHighlight(text = item.title)
        Image(
            painter = painterResource(id = item.image),
            contentDescription = "asd",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Title2.Highlight(text = item.text)
    }
}

@Composable
private fun OnboardFooter(size: Int, index: Int, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .fillMaxWidth()
    ) {
        Indicators(size, index)
        Button(onClick = onClick, shape = CircleShape) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
                contentDescription = "@null",
                tint = Color.White
            )
        }
    }
}

