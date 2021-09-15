package com.deveem.core.network.result

import com.deveem.core.utils.Log
import okhttp3.Headers
import org.json.JSONObject
import retrofit2.Response

class ApiResponse<T> {
    val code: Int
    var body: T? = null
    var message: String?
    var headers: Headers? = null
    var error: ApiError? = null

    val isSuccessful: Boolean
        get() = code in 200..300

    constructor(error: Throwable) {

        Log.e(error.message.toString(), "ApiResponse Exception: ")

        if (error is ApiException) {
            this.code = error.errorCode
            this.message = error.errorMessage
        } else {

            this.code = 500
            this.message = error.message
        }
        this.body = null
    }

    constructor(response: Response<T>) {

        this.code = response.code()

        if (response.isSuccessful) {
            this.body = response.body()
            this.message = null
            this.headers = response.headers()
        } else {
            try {
                val errorMessage: String = response.errorBody()?.string() ?: ""
                val json = JSONObject(errorMessage)
                this.error = ApiError(
                    json.getString("message"),
                    json.getDouble("timestamp"),
                    json.getInt("errorCode")
                )

            } catch (e: Exception) {
                this.body = null
            }

            this.message = when (this.code) {
                429 -> "Too Many Requests"
                else -> response.errorBody().toString()
            }
        }
    }
}