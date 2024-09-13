package com.ajssoftwares.kotlinlearning

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)

