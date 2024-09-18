package com.ajssoftwares.kotlinlearning

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajssoftwares.kotlinlearning.databinding.SampleNewsItemBinding
import com.bumptech.glide.Glide

class NewsAdapter(private var context : Context, private var list : List<Article>) :

    RecyclerView.Adapter<NewsAdapter.NewsVH>() {


    class NewsVH(var binding : SampleNewsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        val view = SampleNewsItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return NewsVH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsVH, position : Int) {
        holder.binding.tvNewsTitle.text = list[position].title
        Glide.with(context).load(list[position].urlToImage).into(holder.binding.ivNews)

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, NewsDetailActivity::class.java)
                .putExtra("position", position)
                .putExtra("newsList", ArrayList(list))
            )
        }
    }
}
