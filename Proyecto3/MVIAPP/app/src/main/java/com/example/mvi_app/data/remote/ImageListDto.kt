package com.example.mvi_app.data.remote

import com.google.gson.annotations.SerializedName

data class ImageListDto(
    @SerializedName("images")
    val images : ArrayList<ImageDto>
)