package com.example.data.base

import android.util.Log
import com.example.data.extensions.parseErrorBody
import com.example.domain.core.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

abstract class BaseRepository {

    protected fun <T, TDomain> doRequests(
        request: suspend () -> Response<T>,
        mapData: suspend (T) -> TDomain
    ) = flow {
        emit(Resource.Loading())
        try {
            val data = request()
            if (data.isSuccessful) {
                val body = data.body()
                if (body != null) {
                    emit(Resource.Success(data = mapData(body)))
                }
            } else {
                emit(
                    Resource.Error(
                        data = null,
                        message = null,
                        errorBody = data.errorBody()?.parseErrorBody()?.error
                    )
                )
            }
        } catch (ioException: Exception) {
            Log.e("RepositoryError", this@BaseRepository.javaClass.name, ioException)

            emit(
                Resource.Error(
                    data = null,
                    message = ioException.localizedMessage ?: "Error Occurred!"
                )
            )
        }
    }

    protected fun <T> doRequest(
        doSomethingInSuccess: ((T) -> Unit)? = null,
        request: suspend () -> T
    ) = flow<Resource<T>> {
        val requestProperty = request()
        emit(Resource.Success(data = requestProperty))
        doSomethingInSuccess?.invoke(requestProperty)
    }.flowOn(Dispatchers.IO).catch { exception ->
        emit(Resource.Error(message = exception.localizedMessage ?: "Error Occurred!"))
    }
}