package com.example.sopt30

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sopt30.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivitySignUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signinIntent = Intent(this, SignInActivity::class.java)

        binding.btnSignUp.setOnClickListener {
            val et_name = binding.etName.getText().toString();
            val et_id = binding.etId.getText().toString();
            val et_pw = binding.etPw.getText().toString();

            if(et_name.isEmpty() || et_id.isEmpty() || et_pw.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show();
            }
            else {
                startActivity(signinIntent)
            }
        }
    }
}