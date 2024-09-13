package com.ajssoftwares.kotlinlearning

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajssoftwares.kotlinlearning.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var newsList = ArrayList<NewsModel>()

    private lateinit var viewModel : NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvNews.layoutManager = LinearLayoutManager(this)


        var apiService = RetrofitInstance.getInstance().create(NewsApiService::class.java)
        var repository = NewsRepo(apiService)
        var factory = NewsVMFactory(repository)
        viewModel = ViewModelProvider(this,factory)[NewsViewModel::class.java]

        viewModel.newsLiveData.observe(this){newsList->
            val articles = newsList.articles
            binding.rvNews.adapter = NewsAdapter(this,articles)
        }



    }
}