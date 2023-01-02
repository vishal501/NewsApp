package com.example.vishalsinghnewsappcodelab_4

import com.example.vishalsinghnewsappcodelab_4.MyDataClass.MyDataItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://newsapi.org/"
interface ApiInterface {
    @GET("v2/top-headlines?country=in&apiKey=ff5703f583a541699de0017eb66905c2")
     fun getData(): Call<MyDataItem>

    object Retrofitobject{
        fun getInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}