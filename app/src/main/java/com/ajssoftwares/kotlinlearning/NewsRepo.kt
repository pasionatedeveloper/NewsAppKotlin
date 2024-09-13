package com.ajssoftwares.kotlinlearning

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//mvvm

class NewsRepo(private var apiService: NewsApiService) {

    private var mutableLiveData = MutableLiveData<NewsModel>()
    var newsLiveData : LiveData<NewsModel> = mutableLiveData

    suspend fun getNews(){
       val response =  apiService.fetchNews("us")
        response.enqueue(object : Callback<NewsModel>{
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                mutableLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {

            }
        })
    }
}