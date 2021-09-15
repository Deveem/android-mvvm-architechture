package com.deveem.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Post (
    val id: Int,
    @Json(name = "userId")
    var userId: Int,
    var title: String?,
    var body: String?
)