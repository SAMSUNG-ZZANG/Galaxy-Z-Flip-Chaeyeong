package com.example.sopt30.data.api

import com.example.sopt30.data.model.request.RequestSignIn
import com.example.sopt30.data.model.response.ResponseSignIn
import com.example.sopt30.data.model.response.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {
    @Headers("Content-Type: application/json")
    @POST("user/login")
    fun postSignIn(
        @Body body : RequestSignIn
    ) : Call<ResponseSignIn>

    @Headers("Content-Type: application/json")
    @POST("user/signup")
    fun postSignUp(
        @Body body : RequestSignIn
    ) : Call<ResponseSignUp>
}