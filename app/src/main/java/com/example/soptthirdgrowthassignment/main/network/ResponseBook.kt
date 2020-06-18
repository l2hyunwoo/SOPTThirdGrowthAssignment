package com.example.soptthirdgrowthassignment.main.network

import com.google.gson.annotations.SerializedName

data class ResponseBook (
    //@SerializedName("documents")
    val documents : MutableList<BookXMLData>
)

data class BookXMLData(
    //@SerializedName("contents")
    val contents : String,
    //@SerializedName("title")
    val title:String,
    //@SerializedName("thumbnail")
    val thumbnail:String
)