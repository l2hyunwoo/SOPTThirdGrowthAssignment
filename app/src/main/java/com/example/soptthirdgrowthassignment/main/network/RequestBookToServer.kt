package com.example.soptthirdgrowthassignment.main.network

import com.example.soptthirdgrowthassignment.login.RequestInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestBookToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://dpai.kakao.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: RequestBookInterface = retrofit.create(
        RequestBookInterface::class.java)
}