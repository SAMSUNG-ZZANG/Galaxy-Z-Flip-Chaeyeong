package com.example.sopt30.data.model.request

import com.google.gson.annotations.SerializedName

data class RequestSignIn(
    @SerializedName("email")
    val email: String,
    val password: String
)
