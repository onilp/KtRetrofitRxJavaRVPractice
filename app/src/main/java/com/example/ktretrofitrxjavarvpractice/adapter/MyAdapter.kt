package com.example.ktretrofitrxjavarvpractice.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ktretrofitrxjavarvpractice.R
import com.example.ktretrofitrxjavarvpractice.model.Model
import kotlinx.android.synthetic.main.list_item.view.*


class MyAdapter (val context : Context, val photoList : List<Model.Photo>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder : MyAdapter.MyViewHolder, position: Int) {
        holder.bindValues(photoList.get(position))

    }

    class MyViewHolder (itemView : View) : RecyclerView.ViewHolder (itemView){
        fun bindValues(photo : Model.Photo) {
            itemView.textViewAlbumId.text = photo.albumId.toString()
            itemView.textViewId.text = photo.id.toString()
            itemView.textViewTitle.text = photo.title
            itemView.textViewUrl.text = photo.url
            itemView.textViewtUrl.text = photo.tUrl

        }


    }

}