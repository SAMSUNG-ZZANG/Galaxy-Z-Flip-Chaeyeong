package com.example.sopt30

import com.google.gson.annotations.SerializedName

data class RequestSignUp(
    @SerializedName("name")
    val name: String,
    val email: String,
    val password: String
)
