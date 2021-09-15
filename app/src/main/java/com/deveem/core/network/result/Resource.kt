package com.deveem.core.network.result

import com.autocare.core.network.result.Status

data class Resource<out T>(val status: Status, val data: T?, val message: String?, val code: Int?, val error: ApiError? = null) {
    companion object {
        fun <T> success(data: T?, code: Int? = null): Resource<T> {
            return Resource(Status.SUCCESS, data, null, code)
        }

        fun <T> error(msg: String?, data: T?, code: Int?, error: ApiError?): Resource<T> {
            return Resource(Status.ERROR, data, msg, code, error)
        }

        fun <T> error(response: ApiResponse<T>): Resource<T> {
            return Resource(Status.ERROR, response.body, response.message, response.code, response.error)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null, null)
        }
    }
}