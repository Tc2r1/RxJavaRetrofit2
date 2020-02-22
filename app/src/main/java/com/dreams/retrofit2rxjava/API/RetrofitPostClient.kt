package com.dreams.retrofit2rxjava.API

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitPostClient {
    // Base Url For retrofit:
    // http://jsonplaceholder.typicode.com/
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private var ourInstance : Retrofit? = null

    val instance: Retrofit
    get() {
        if(ourInstance == null)
        {
            ourInstance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return ourInstance!!
    }
}