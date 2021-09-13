package com.deveem.core.network

import android.content.Context
import com.deveem.data.local.AppPrefs
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val appPreferences: AppPrefs, private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request()
//        val newRequest = if (appPreferences.
//            token != null) {
//            req.newBuilder()
//                //.addHeader("Authorization", "Bearer ${appPreferences.token}")
//                .build()
//        } else {
//            req.newBuilder()
//                .build()
//        }

        val response = chain.proceed(req.newBuilder().build())

        if (response.code == 401 || response.code == 403) {

            if (appPreferences.token != null) {

//                val context: Context = (context.applicationContext as App).applicationContext

//                val intent = Intent(context, RegisterActivity::class.java)
//                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                context.startActivity(intent)
            }

            appPreferences.token = null
        }
        return response
    }
}