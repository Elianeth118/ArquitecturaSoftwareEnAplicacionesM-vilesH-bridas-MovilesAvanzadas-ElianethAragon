package com.example.mvi_app.data

import com.example.mvi_app.data.remote.ImageListDto
import retrofit2.http.GET
import retrofit2.http.Query


interface ImageApi {
    @GET("search")
    suspend fun getInfiniteApiImages(
        @Query("q") q : String
    ): ImageListDto
}