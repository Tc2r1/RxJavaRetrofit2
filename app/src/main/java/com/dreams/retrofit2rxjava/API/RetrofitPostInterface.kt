package com.dreams.retrofit2rxjava.API

import com.dreams.retrofit2rxjava.Model.Post
import io.reactivex.Observable
import retrofit2.http.GET



interface RetrofitPostInterface {

    @get:GET("posts")
    val posts: Observable<List<Post>>
}