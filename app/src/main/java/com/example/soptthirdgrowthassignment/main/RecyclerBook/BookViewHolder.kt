package com.example.soptthirdgrowthassignment.main.RecyclerBook

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soptthirdgrowthassignment.R
import com.example.soptthirdgrowthassignment.main.network.BookXMLData

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img_book : ImageView = itemView.findViewById<ImageView>(R.id.img_book)
    val tv_title : TextView = itemView.findViewById<TextView>(R.id.tv_title)
    val tv_content : TextView = itemView.findViewById<TextView>(R.id.tv_content)
    fun bind(bookData: BookXMLData){
        Glide.with(itemView).load(bookData.thumbnail).into(img_book)
        tv_title.text = bookData.title
        tv_content.text = bookData.contents
    }
}