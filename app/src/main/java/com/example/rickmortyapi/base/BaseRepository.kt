package com.example.rickmortyapi.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.bumptech.glide.load.engine.Resource
import kotlinx.coroutines.Dispatchers
import com.example.rickmortyapi.utils.Resource
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doRequest(
        request: suspend () -> Response<T>
    ): LiveData<com.bumptech.glide.load.engine.Resource<T>> = liveData(Dispatchers.IO) {
        emit(com.example.rickmortyapi.utils.Resource.Loading())
        try {
            val response = request.invoke()
            if (response.isSuccessful && response.body() != null && response.code() in 200..300) {
                response.body()?.let {
                    emit(Resource.Success(response.body()!!))
                }
            }
        } catch (io: IOException) {
            emit(com.example.rickmortyapi.utils.Resource.Error(io.message ?: "Unknown Error!"))
        }
    }
}