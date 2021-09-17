package com.deveem.data.remote

import com.deveem.core.network.BaseDataSource
import org.koin.dsl.module

class RemoteDataSource(private val apiService: ApiService) : BaseDataSource() {

    // Posts
    suspend fun getPosts() = getResult { apiService.getPosts() }
    suspend fun getPost(id: Int) = getResult { apiService.getPost(id) }
}