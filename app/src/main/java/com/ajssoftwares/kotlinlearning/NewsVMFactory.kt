package com.ajssoftwares.kotlinlearning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsVMFactory(private var repository: NewsRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(repository) as T
    }
}