package com.ajssoftwares.kotlinlearning

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajssoftwares.kotlinlearning.databinding.ActivityNewsDetailBinding
import com.bumptech.glide.Glide

class NewsDetailActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityNewsDetailBinding
    
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val intent = intent
        val position = intent.getIntExtra("position",0)
        val list = intent.getSerializableExtra("newsList") as ArrayList<Article>
        
        binding.newsTitleTv.text = list[position].title
        binding.newsDescritpionTv.text = list[position].description
        Glide.with(this).load(list[position].urlToImage).into(binding.newsIv)

        binding.readFullArticleBtn.setOnClickListener {
            val intent = Intent(applicationContext, WebViewActivity::class.java)
            intent.putExtra("url", list[position].url)
            startActivity(intent)
        }
    }
}