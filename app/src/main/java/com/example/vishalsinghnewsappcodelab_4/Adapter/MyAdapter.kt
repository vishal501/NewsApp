package com.example.vishalsinghnewsappcodelab_4.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vishalsinghnewsappcodelab_4.HomeFragment
import com.example.vishalsinghnewsappcodelab_4.MyDataClass.Article
import com.example.vishalsinghnewsappcodelab_4.R
import kotlinx.android.synthetic.main.home_news_layout.view.*


class MyAdapter(private val list: List<Article>,private val homeFragment: HomeFragment):RecyclerView.Adapter<MyAdapter.MyHolder>() {
    inner class MyHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bind(data: Article) {

            itemView.tv_newsHeading.text=data.title
            itemView.tv_news.text=data.description
            itemView.tv_seemoreHeading.text=data.publishedAt
            Glide.with(homeFragment).load(data.urlToImage).into(itemView.news_img)

        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_news_layout,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data=list[position]
        holder.bind(data)
        homeFragment.itemClicked(position)
        holder.itemView.card.setOnClickListener {
            homeFragment.Appbar()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}