package com.deveem.core.network

import com.autocare.BuildConfig.BASE_URL
import com.autocare.data.remote.ApiService
import com.readystatesoftware.chuck.ChuckInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    factory { AuthInterceptor(get(), androidContext()) }
    factory { ChuckInterceptor(androidContext()) }
    factory { provideOkHttpClient(get(), get()) }
    factory { provideApi(get()) }
    factory { provideMoshi() }
    single { provideRetrofit(get(), get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}

fun provideOkHttpClient(
    authInterceptor: AuthInterceptor,
    chuckInterceptor: ChuckInterceptor
): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(chuckInterceptor)
        .addInterceptor(interceptor)
        .build()
}

fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}

fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)