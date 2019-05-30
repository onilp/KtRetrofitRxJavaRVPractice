package com.example.ktretrofitrxjavarvpractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.ktretrofitrxjavarvpractice.adapter.MyAdapter
import com.example.ktretrofitrxjavarvpractice.model.Model
import com.example.ktretrofitrxjavarvpractice.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var myAdapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewPhotos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiInterface = ApiInterface.getRetrofitInstance().getPhotos()
        apiInterface.enqueue(object : Callback<List<Model.Photo>>{
            override fun onFailure(call: Call<List<Model.Photo>>, t: Throwable) {
                Log.e("Error", t.message)

            }

            override fun onResponse(call: Call<List<Model.Photo>>, response: Response<List<Model.Photo>>) {
                myAdapter = MyAdapter(this@MainActivity,response.body()!!)
                recyclerView.adapter = myAdapter
                myAdapter.notifyDataSetChanged()
            }

        })
    }
}
