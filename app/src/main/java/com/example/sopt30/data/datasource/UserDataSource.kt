package com.example.sopt30.data.datasource

import com.example.sopt30.data.model.request.RequestSignIn
import com.example.sopt30.data.model.response.ResponseSignIn

interface UserDataSource {
    suspend fun postSignIn(body: RequestSignIn): ResponseSignIn
}