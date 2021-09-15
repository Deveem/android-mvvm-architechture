package com.deveem.di

import com.deveem.core.repos.PostRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules : Module = module {
    single { PostRepository(get()) }
}