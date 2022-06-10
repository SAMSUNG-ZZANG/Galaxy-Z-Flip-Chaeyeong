package com.example.sopt30.domain.model

import com.google.gson.annotations.SerializedName

data class SignInData(val data: MemberInfo
) {
    data class MemberInfo(
        @SerializedName("id")
        val id: Int,
        @SerializedName("nickname")
        val nickname: String,
        @SerializedName("accesstoken")
        val accesstoken: String
    )
}
