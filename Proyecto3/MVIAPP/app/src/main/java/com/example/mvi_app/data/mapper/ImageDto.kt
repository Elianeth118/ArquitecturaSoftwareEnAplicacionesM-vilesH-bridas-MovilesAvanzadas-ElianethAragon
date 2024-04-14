package com.example.mvi_app.data.mapper

import com.example.mvi_app.data.remote.ImageDto
import com.example.mvi_app.domain.model.Image

fun ImageDto.toImage(): Image {
    return Image(
        id = id,
        width = width,
        height = height,
        srcSmall = srcSmall,
        src = src
    )
}