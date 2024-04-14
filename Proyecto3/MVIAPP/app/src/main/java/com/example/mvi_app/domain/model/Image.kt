package com.example.mvi_app.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Image(
    var id: String,
    var src: String,
    var srcSmall: String,
    var width: Int,
    var height: Int,
)