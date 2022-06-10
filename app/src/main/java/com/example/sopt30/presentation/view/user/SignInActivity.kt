package com.example.sopt30.presentation.view.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sopt30.data.model.request.RequestSignIn
import com.example.sopt30.data.model.response.ResponseSignIn
import com.example.sopt30.ServiceCreator
import com.example.sopt30.databinding.ActivitySignInBinding
import com.example.sopt30.presentation.view.home.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeIntent = Intent(this, HomeActivity::class.java)
        val signUpIntent = Intent(this, SignUpActivity::class.java)

        binding.btnLogin.setOnClickListener{
            val etId = binding.etId.text.toString();
            val etPw = binding.etPw.text.toString();

            val requestSignIn = RequestSignIn(
                email = etId,
                password = etPw
            )

            val call: Call<ResponseSignIn> = ServiceCreator.soptService.postLogin(requestSignIn)

            if(etId.isEmpty() || etPw.isEmpty()){
                Toast.makeText(this, "로그인실패", Toast.LENGTH_SHORT).show();
            }
            else{
                call.enqueue(object : Callback<ResponseSignIn> {
                    override fun onResponse(
                        call: Call<ResponseSignIn>,
                        response: Response<ResponseSignIn>
                    ) {
                        if(response.isSuccessful) {
                            Toast.makeText(this@SignInActivity, etId.plus("님 환영합니다"), Toast.LENGTH_SHORT).show();
                            startActivity(homeIntent)
                        } else Toast.makeText(this@SignInActivity, "로그인 실패", Toast.LENGTH_SHORT).show();
                    }

                    override fun onFailure(call: Call<ResponseSignIn>, t: Throwable) {
                        Log.e("NetworkTest", "error $t")
                    }
                })
            }
        }

        binding.btnSignUp.setOnClickListener {
            startActivity(signUpIntent)
        }
    }
}