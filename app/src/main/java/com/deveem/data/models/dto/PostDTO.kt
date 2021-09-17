package com.deveem.data.models.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostDTO (
    var title: String,
    var body: String
)