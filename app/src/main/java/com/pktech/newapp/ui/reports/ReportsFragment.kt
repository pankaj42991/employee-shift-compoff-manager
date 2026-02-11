package com.pktech.newapp.ui.reports

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pktech.newapp.R
import com.pktech.newapp.databinding.FragmentReportsBinding

class ReportsFragment : Fragment(R.layout.fragment_reports) {

    private lateinit var binding: FragmentReportsBinding
    private val viewModel: ReportsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentReportsBinding.bind(view)

        val employeeId = 1
        val month = 2   // Feb example
        val year = 2026

        binding.btnMonthly.setOnClickListener {
            viewModel.getMonthlyReport(employeeId, month, year)
                .observe(viewLifecycleOwner) { report ->
                    binding.txtReport.text = report
                }
        }

        binding.btnYearly.setOnClickListener {
            viewModel.getYearlyReport(employeeId, year)
                .observe(viewLifecycleOwner) { report ->
                    binding.txtReport.text = report
                }
        }

        binding.btnPdf.setOnClickListener {
            // Next step: PDF Generator helper yahin se call hoga
        }
    }
}