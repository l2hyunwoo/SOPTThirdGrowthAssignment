package com.example.soptthirdgrowthassignment.main.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface RequestBookInterface {
    //@Headers("Authorization: KakaoAK bbf808e932d7b91a6dda0a868f5c766f")
    @GET("/v3/search/book?target=title")
    fun requestSearchBook(@Query("query")bookTitle : String, @Header("Authorization") auth : String ) : Call<ResponseBook>
}