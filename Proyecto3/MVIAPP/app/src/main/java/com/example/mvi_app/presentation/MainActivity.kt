package com.example.mvi_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvi_app.presentation.screens.HomeScreen
import com.example.mvi_app.presentation.screens.HomeScreenViewModel
import com.example.mvi_app.presentation.theme.MVIAPPTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVIAPPTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
                    HomeScreen(state = homeScreenViewModel.state) {
                        homeScreenViewModel.onEvent(it)
                    }
                }
            }
        }
    }
}
