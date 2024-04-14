package com.example.mvi_app.domain.repository


import com.example.mvi_app.core.util.Resources
import com.example.mvi_app.domain.model.Image
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun getImages(
        text: String
    ): Flow<Resources<List<Image>>>
}