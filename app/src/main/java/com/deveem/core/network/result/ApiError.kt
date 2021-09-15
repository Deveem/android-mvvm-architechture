package com.deveem.core.network.result

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiError(
        val message: String?,
        val title: Double?,
        val code: Int?
)