package com.pktech.myapp.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pktech.myapp.auth.LoginActivity
import com.pktech.myapp.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private val viewModel: DashboardViewModel by viewModels()
    private var isAdmin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get role from login (for now hardcoded, replace with login role)
        isAdmin = viewModel.isAdminUser()

        setupUI()
        loadSummary()
        setupNavigation()
    }

    private fun setupUI() {
        if (isAdmin) {
            binding.tvWelcome.text = "Welcome Admin"
            binding.cardShifts.visibility = android.view.View.VISIBLE
            binding.cardCompOff.visibility = android.view.View.VISIBLE
            binding.cardEmployees.visibility = android.view.View.VISIBLE
        } else {
            binding.tvWelcome.text = "Welcome Employee"
            binding.cardShifts.visibility = android.view.View.VISIBLE
            binding.cardCompOff.visibility = android.view.View.VISIBLE
            binding.cardEmployees.visibility = android.view.View.GONE
        }
    }

    private fun loadSummary() {
        val totalShifts = viewModel.getTotalShifts()
        val totalCompOff = viewModel.getTotalCompOff()
        val totalEmployees = viewModel.getTotalEmployees()

        binding.tvShiftsCount.text = totalShifts.toString()
        binding.tvCompOffCount.text = totalCompOff.toString()
        binding.tvEmployeesCount.text = totalEmployees.toString()
    }

    private fun setupNavigation() {
        binding.cardShifts.setOnClickListener {
            startActivity(Intent(this, ShiftsFragmentActivity::class.java))
        }
        binding.cardCompOff.setOnClickListener {
            startActivity(Intent(this, CompOffFragmentActivity::class.java))
        }
        binding.cardEmployees.setOnClickListener {
            startActivity(Intent(this, EmployeesFragmentActivity::class.java))
        }
        binding.btnLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}