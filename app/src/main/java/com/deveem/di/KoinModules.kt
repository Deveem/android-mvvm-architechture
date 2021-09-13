package com.deveem.di

import com.deveem.core.network.networkModule
import com.deveem.data.local.prefModule

val koinModules = listOf(
    networkModule,
    repoModules,
    viewModules,
    prefModule,
)