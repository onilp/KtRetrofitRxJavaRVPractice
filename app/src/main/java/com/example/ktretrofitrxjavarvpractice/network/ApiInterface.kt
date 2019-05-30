package com.example.ktretrofitrxjavarvpractice.network

import com.example.ktretrofitrxjavarvpractice.model.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    //https://jsonplaceholder.typicode.com/photos
    @GET("photos")
    fun getPhotos() : Call<List<Model.Photo>>

    companion object{
        var BASE_URL = "https://jsonplaceholder.typicode.com/"
        fun getRetrofitInstance() : ApiInterface {

            val retrofit  = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }


    }

}