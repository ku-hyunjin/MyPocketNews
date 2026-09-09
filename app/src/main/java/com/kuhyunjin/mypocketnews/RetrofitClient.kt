package com.kuhyunjin.mypocketnews

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://en.wikipedia.org/"
    private const val USER_AGENT =
        "MyPocketNews/1.0 (https://github.com/ku-hyunjin/MyPocketNews)"

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .header("User-Agent", USER_AGENT)
                .build()

            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val newsApi: NewsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }
}
