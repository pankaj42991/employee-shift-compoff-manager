package com.pktech.newapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pktech.newapp.databinding.ActivityLoginBinding
import com.pktech.newapp.ui.dashboard.DashboardActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val pass = binding.etPassword.text.toString()

            // Simplified – ViewModel attach karo production me
            if (email.isNotEmpty() && pass.isNotEmpty()) {
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            }
        }
    }
}