package com.deveem.data.remote

import com.deveem.data.models.Post
import com.deveem.data.models.dto.PostDTO
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    /**  EXAMPLES REQUESTS  **/

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("/posts/{id}")
    suspend fun getPost(
        @Path(value = "id") id: Int
    ): Response<Post>

    @POST("/posts")
    suspend fun createPost(@Body dto: PostDTO): Response<Post>

    @PATCH("/posts")
    suspend fun updatePassword(@Body dto: PostDTO): Response<Post>

    /*Email Sender Start*/
    @PUT("/posts")
    suspend fun emailRegisterDetails(@Body detailsDTO: PostDTO): Response<Post>

    @DELETE("/posts/{id}")
    suspend fun deleteAddress(@Path(value = "id") id: Int): Response<Post>
}