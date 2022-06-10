package com.example.sopt30.data.mapper

import com.example.sopt30.data.model.response.ResponseSignIn
import com.example.sopt30.domain.model.SignInData

object UserMapper {

    fun mapperToSignIn(responseSignIn: ResponseSignIn): SignInData {
        return SignInData(
            data = SignInData.MemberInfo(responseSignIn.data.email, responseSignIn.data.name, responseSignIn.data.access)
        )
    }
}