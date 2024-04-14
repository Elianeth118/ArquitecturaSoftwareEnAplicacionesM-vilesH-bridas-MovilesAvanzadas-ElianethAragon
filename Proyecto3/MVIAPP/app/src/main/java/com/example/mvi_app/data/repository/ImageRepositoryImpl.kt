package com.example.mvi_app.data.repository

//import android.net.http.HttpException
import retrofit2.HttpException
import com.example.mvi_app.core.util.Resources
import com.example.mvi_app.data.ImageApi
import com.example.mvi_app.data.mapper.toImage
import com.example.mvi_app.domain.model.Image
import com.example.mvi_app.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageRepositoryImpl @Inject constructor(
    private val imageApi: ImageApi
) : ImageRepository {
    override fun getImages(text: String): Flow<Resources<List<Image>>> {
        return flow {

            emit(Resources.Loading(true))

            val remoteList = try {
                imageApi.getInfiniteApiImages(text)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resources.Error("Could not load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resources.Error("Could not load data"))
                null
            }
            remoteList.let { listing ->
                emit(Resources.Success(data = listing?.images?.map { it.toImage() }))
                emit(Resources.Loading(false))
            }
        }
    }
}