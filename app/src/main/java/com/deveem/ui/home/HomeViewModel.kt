package com.deveem.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.deveem.core.network.result.Resource
import com.deveem.core.repos.PostRepository
import com.deveem.core.ui.BaseViewModel
import com.deveem.data.models.Post

class HomeViewModel(private val postRepository: PostRepository) : BaseViewModel() {

    /*Get posts*/
    private val _posts = MutableLiveData<Boolean>()
    val posts: LiveData<Resource<List<Post>>> = _posts.switchMap {
        postRepository.getPosts()
    }
    fun onGetPosts() {
        _posts.postValue(true)
    }

}