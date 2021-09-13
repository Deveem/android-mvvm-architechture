package com.deveem.data.remote

import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/posts")
    suspend fun getPosts(
        @Path(value = "userId") userId: Int,
        @Path(value = "token") token: String
    ): Response<Any>
}