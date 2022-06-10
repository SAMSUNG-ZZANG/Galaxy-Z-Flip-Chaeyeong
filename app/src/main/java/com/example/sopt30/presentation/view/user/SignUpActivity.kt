package com.example.sopt30.presentation.view.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sopt30.data.model.request.RequestSignUp
import com.example.sopt30.data.model.response.ResponseSignUp
import com.example.sopt30.ServiceCreator
import com.example.sopt30.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySignUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signinIntent = Intent(this, SignInActivity::class.java)

        binding.btnSignUp.setOnClickListener {
            val etName = binding.etName.text.toString();
            val etId = binding.etId.text.toString();
            val etPw = binding.etPw.text.toString();

            val requestSignUp = RequestSignUp(
                name = etName,
                email = etId,
                password = etPw
            )

            val call: Call<ResponseSignUp> = ServiceCreator.soptService.postSignUp(requestSignUp)

            if(etName.isEmpty() || etId.isEmpty() || etPw.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show();
            }
            else {
                call.enqueue(object: Callback<ResponseSignUp> {
                    override fun onResponse(
                        call: Call<ResponseSignUp>,
                        response: Response<ResponseSignUp>
                    ) {
                        if(response.isSuccessful) {
                            Toast.makeText(this@SignUpActivity, etId.plus("님 환영합니다"), Toast.LENGTH_SHORT).show();
                            startActivity(signinIntent)
                        } else Toast.makeText(this@SignUpActivity, "회원가입 실패", Toast.LENGTH_SHORT).show();
                    }

                    override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                        Log.e("NetworkTest", "error $t")
                    }

                })
            }
        }
    }
}