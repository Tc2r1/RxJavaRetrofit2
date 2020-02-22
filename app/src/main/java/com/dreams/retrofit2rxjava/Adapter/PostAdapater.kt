package com.dreams.retrofit2rxjava.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dreams.retrofit2rxjava.Model.Post
import com.dreams.retrofit2rxjava.R

class PostAdapater(internal var context: Context, internal var postList:List<Post>)
    : RecyclerView.Adapter<PostViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_layout, parent,false)

        return PostViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int)
    {
        // Bind the view to their data

        val currentPost:Post = postList[position]

        holder.txt_author.text = currentPost.userId.toString()
        holder.txt_title.text = currentPost.title.toString()

        holder.txt_content.text = StringBuilder(currentPost.body.substring(0,40))
            .append("...").toString()

    }

}