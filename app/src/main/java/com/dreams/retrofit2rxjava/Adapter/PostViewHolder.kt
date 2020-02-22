package com.dreams.retrofit2rxjava.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_layout.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val txt_author = itemView.tv_author
    val txt_content = itemView.tv_content
    val txt_title = itemView.tv_title
}