package com.deveem.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable


@JsonClass(generateAdapter = true)
data class Post (
    val id: Int,
    @Json(name = "userId")
    var userId: Int,
    var title: String?,
    var body: String?
): Serializable