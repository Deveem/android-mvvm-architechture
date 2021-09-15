package com.deveem.data.remote

import com.deveem.data.models.Post
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}