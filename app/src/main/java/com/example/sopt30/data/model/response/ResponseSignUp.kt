package com.example.sopt30.data.model.response

data class ResponseSignUp(
    val status: Int,
    val message: String,
    val data: Data
) {
    data class Data(
        val id: String
    )
}
