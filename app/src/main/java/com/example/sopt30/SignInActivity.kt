package com.example.sopt30

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.Toast
import com.example.sopt30.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signupIntent = Intent(this, SignUpActivity::class.java)
        val homeIntent = Intent(this, HomeActivity::class.java)

        binding.btnLogin.setOnClickListener {
            Toast.makeText(this, "로그인성공", Toast.LENGTH_SHORT).show();
            val et_id = binding.etId.getText().toString();
            val et_pw = binding.etPw.getText().toString();
            if(et_id.isEmpty() || et_pw.isEmpty()){
                Toast.makeText(this, "로그인실패", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, et_id.plus("님 환영합니다"), Toast.LENGTH_SHORT).show();
                startActivity(homeIntent)
            }
        }

        binding.btnSignUp.setOnClickListener {
            Toast.makeText(this, "root, message", Toast.LENGTH_SHORT);
            startActivity(signupIntent)
        }

    }
}