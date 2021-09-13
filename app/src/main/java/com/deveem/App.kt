package com.deveem

import android.app.Application
import com.deveem.core.utils.Log
import com.deveem.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Init Koin DI
        startKoin {
            androidContext(this@App)
            modules(koinModules)
        }

        // Init Timber log
        Log.init()
    }
}