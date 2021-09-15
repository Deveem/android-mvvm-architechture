package com.deveem.core.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.deveem.core.network.result.Resource
import com.deveem.data.models.Post
import com.deveem.data.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers

class PostRepository(private val dataSource: RemoteDataSource) {

    fun getPosts(): LiveData<Resource<List<Post>>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val response = dataSource.getPosts()
            emit(response)
        }
}