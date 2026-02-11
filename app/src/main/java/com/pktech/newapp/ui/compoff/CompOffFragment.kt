package com.pktech.newapp.ui.compoff

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pktech.newapp.R
import com.pktech.newapp.databinding.FragmentCompOffBinding

class CompOffFragment : Fragment(R.layout.fragment_comp_off) {

    private lateinit var binding: FragmentCompOffBinding
    private val viewModel: CompOffViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCompOffBinding.bind(view)

        val employeeId = 1   // later login se dynamic aayega

        viewModel.getEmployeeCompOff(employeeId).observe(viewLifecycleOwner) {
            binding.txtEarned.text = it.earned.toString()
            binding.txtUsed.text = it.used.toString()
            binding.txtCarry.text = it.carryForward.toString()
        }

        binding.btnRefresh.setOnClickListener {
            viewModel.calculateCarryForward(employeeId)
        }
    }
}