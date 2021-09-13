package com.deveem.data.local

import android.content.Context
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val prefModule = module {
    single { AppPrefs(androidContext()) }
}

class AppPrefs(context: Context) {

    private val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    private var _token: String? = null

    var token: String?
        get() = token()
        set(value) = prefs.edit().putString("token", value).apply()

    private fun token(): String? {
        _token?.let { return it }
            ?: run {
                _token = prefs.getString("token", null)
                return _token
            }
    }
}