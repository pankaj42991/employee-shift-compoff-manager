package com.pktech.newapp.ui.admin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pktech.newapp.R
import com.pktech.newapp.databinding.FragmentAdminBinding
import java.time.LocalDate

class AdminFragment : Fragment(R.layout.fragment_admin) {

    private lateinit var binding: FragmentAdminBinding
    private val viewModel: AdminViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdminBinding.bind(view)

        binding.btnEmployees.setOnClickListener {
            // Navigate → Employee Management Screen
        }

        binding.btnAddHoliday.setOnClickListener {
            viewModel.addHoliday(LocalDate.now(), "Festival", true)
        }

        binding.btnOverrideShift.setOnClickListener {
            viewModel.overrideShift(2, LocalDate.now(), "NIGHT")
        }

        binding.btnRegenerate.setOnClickListener {
            viewModel.regenerateSchedule(2, 2026)
        }
    }
}