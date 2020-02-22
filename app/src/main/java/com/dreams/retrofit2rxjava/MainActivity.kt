package com.dreams.retrofit2rxjava

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dreams.retrofit2rxjava.API.RetrofitPostClient
import com.dreams.retrofit2rxjava.API.RetrofitPostInterface
import com.dreams.retrofit2rxjava.Adapter.PostAdapater
import com.dreams.retrofit2rxjava.Model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal lateinit var jsonApi: RetrofitPostInterface
    internal lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init API
        val retrofit = RetrofitPostClient.instance
        jsonApi = retrofit.create(RetrofitPostInterface::class.java)
        compositeDisposable = CompositeDisposable()

        // View
        recyclerview_posts.setHasFixedSize(true)
        recyclerview_posts.layoutManager = LinearLayoutManager(this)

        fetchData()

    }

    private fun fetchData() {
        compositeDisposable.add(jsonApi.posts

            // SubscribeOn allows us to choose which threads
            // will run the entire process, This way we can
            // easily take the work off the main thread.
            .subscribeOn(Schedulers.io())

            // ObserveOn On only allows the code to run on the Observed thread
            // that is below it. Only ObserveOn and .subscribe will run on the main thread.
            .observeOn(AndroidSchedulers.mainThread())

            // posts is triggered whenever data is observed.
            .subscribe({
                displayData(it)
            },
                {
                    Log.e("API ERROR", it.message)

            })
        )
    }

    private fun displayData(posts: List<Post>?) {

        val adapter = PostAdapater(this, posts!!)
        recyclerview_posts.adapter = adapter
    }
}
