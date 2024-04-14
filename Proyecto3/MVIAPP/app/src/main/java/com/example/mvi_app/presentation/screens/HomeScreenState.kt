package com.example.mvi_app.presentation.screens

import com.example.mvi_app.domain.model.Image

data class HomeScreenState(
    val images: List<Image> = emptyList(),
    val isLoading: Boolean = false,
    val text : String = ""
)