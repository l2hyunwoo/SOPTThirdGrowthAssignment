package com.example.soptthirdgrowthassignment.register

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterInterface {
    @POST("/user/signup")
    fun requestRegister(@Body body: RequestRegister) : Call<ResponseRegister>
}