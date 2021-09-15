package com.deveem.core.network

import com.deveem.core.network.result.ApiError
import com.deveem.core.network.result.Resource
import com.deveem.core.utils.Log
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {

        try {
            val response = call()

            if (response.isSuccessful) {
                val body = response.body()

                if (body != null) return Resource.success(body)
            } else {
                return Resource.error(response.message(), response.body(), response.code(), null)
            }
        } catch (e: Exception) {
            Log.d(e.message)
            return Resource.error(e.message ?: e.toString(), null, 429, ApiError(e.message ?: e.toString(), null, null))
        }

        return Resource.error(null, null, 429, null)
    }
}