package com.example.recipefinder

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.recipefinder.ui.DishViewModel
import com.example.recipefinder.ui.components.FilterRow
import com.example.recipefinder.ui.components.Header
import com.example.recipefinder.ui.components.NavigationRail
import com.example.recipefinder.ui.components.RecommendationSection
import com.example.recipefinder.ui.components.ScheduleCookingTimeContent
import com.example.recipefinder.ui.components.commonComponents.FooterCard
import com.example.recipefinder.ui.theme.RecipeFinderTheme
import com.example.recipefinder.ui.theme.screenBg
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeFinderTheme {

                CookAssistantApp()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CookAssistantApp() {
    val sheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(skipHiddenState = false)
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = sheetState,
        sheetContent = {
            ScheduleCookingTimeContent(onClose = {
                coroutineScope.launch {
                    sheetState.bottomSheetState.hide()
                }
            })
        },
        sheetPeekHeight = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(screenBg)
                .padding(16.dp)
        ) {
            NavigationRail()
            MainScreen(
                modifier = Modifier.fillMaxSize(),
                onScheduleButtonClick = {
                    coroutineScope.launch {
                        sheetState.bottomSheetState.expand()
                    }
                }
            )
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, onScheduleButtonClick: () -> Unit) {
    Column(modifier = modifier) {
        val dishViewModel: DishViewModel = hiltViewModel()
        val dishes by dishViewModel.dishes.collectAsState()
        Header()
        FilterRow()
        RecommendationSection(dishes = dishes, onClicked = onScheduleButtonClick)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 48.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FooterCard(
                text = "Explore all dishes",
                modifier = Modifier.weight(1f),
                imageRes = R.drawable.food
            )
            FooterCard(text = "Confused what to cook?", modifier = Modifier.weight(1f))
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavigationRailPreview() {
    RecipeFinderTheme {
        CookAssistantApp()
    }
}