package com.ajssoftwares.kotlinlearning

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun fetchNews(@Query("country") country : String) : Call<NewsModel>


}