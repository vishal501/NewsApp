package com.example.vishalsinghnewsappcodelab_4.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.vishalsinghnewsappcodelab_4.DiscoverFragment
import com.example.vishalsinghnewsappcodelab_4.R
import kotlinx.android.synthetic.main.quoteimg_layout.view.*

class QuoteAdapter(val context: Context) :
    RecyclerView.Adapter<QuoteAdapter.MyViewHolder>(){

    private val img = arrayOf(R.drawable.inshorts,R.drawable.inshorts,R.drawable.inshorts,R.drawable.inshorts)
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val img: ImageView
                init{
                    img = view.findViewById(R.id.quote_img)

                }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quoteimg_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteAdapter.MyViewHolder, position: Int) {
        holder.itemView.quote_img.setImageResource(img[position])
        holder.itemView.quote_img.setOnClickListener {
            val intent= Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return img.size
    }

}