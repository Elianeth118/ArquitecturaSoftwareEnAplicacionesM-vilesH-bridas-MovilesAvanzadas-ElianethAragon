package com.example.mvi_app.core.di


import com.example.mvi_app.data.ImageApi
import dagger.Provides
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton




@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    annotation class Module

    @Provides
    @Singleton
    fun provideInfiniteImageApi(): ImageApi {
        return Retrofit.Builder()
            .baseUrl("https://lexica.art/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }).build()
            )
            .build()
            .create(ImageApi::class.java)
    }
}