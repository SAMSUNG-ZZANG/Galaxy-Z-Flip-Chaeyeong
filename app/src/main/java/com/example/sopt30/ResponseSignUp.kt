package com.example.sopt30

data class ResponseSignUp(
    val status: Int,
    val message: String,
    val data: Data
) {
    data class Data(
        val id: String
    )
}
