package com.example.sopt30

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sopt30.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySignUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signinIntent = Intent(this, SignInActivity::class.java)

        binding.btnSignUp.setOnClickListener {
            val etName = binding.etName.getText().toString();
            val etId = binding.etId.getText().toString();
            val etPw = binding.etPw.getText().toString();

            if(etName.isEmpty() || etId.isEmpty() || etPw.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show();
            }
            else {
                startActivity(signinIntent)
            }
        }
    }
}