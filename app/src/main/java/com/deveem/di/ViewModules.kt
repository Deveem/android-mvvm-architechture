package com.deveem.di

import com.deveem.ui.home.HomeViewModel
import com.deveem.ui.post.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { HomeViewModel() }
    viewModel { PostViewModel(get()) }
}