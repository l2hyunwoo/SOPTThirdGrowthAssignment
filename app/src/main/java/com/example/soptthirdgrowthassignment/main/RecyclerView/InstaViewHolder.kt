package com.example.soptthirdgrowthassignment.main.RecyclerView

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soptthirdgrowthassignment.R

class InstaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv_username : TextView = itemView.findViewById<TextView>(R.id.tv_username)
    val img_profile : ImageView = itemView.findViewById<ImageView>(R.id.img_profile)
    val img_contents : ImageView = itemView.findViewById<ImageView>(R.id.img_contents)

    fun bind(instaData : InstaData){
        tv_username.text = instaData.userName
        Glide.with(itemView).load(instaData.img_profile).into(img_profile)
        Glide.with(itemView).load(instaData.img_contents).into(img_contents)
    }
}