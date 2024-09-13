package com.ajssoftwares.kotlinlearning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private var repository : NewsRepo) : ViewModel() {

    var newsLiveData = repository.newsLiveData

    init {
        fetchNews()
    }

    private fun fetchNews(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getNews()
        }
    }
}