package com.pktech.newapp.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.pktech.newapp.R
import com.pktech.newapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view)

        val userId = 1

        viewModel.getUserProfile(userId).observe(viewLifecycleOwner) { profile ->
            binding.txtName.text = profile.name
            binding.txtRole.text = profile.role
            binding.txtCompOff.text = "Comp-Off: ${profile.compOff}"
        }

        binding.btnBackup.setOnClickListener {
            viewModel.backupData()
        }

        binding.btnRestore.setOnClickListener {
            viewModel.restoreData()
        }

        binding.btnLogout.setOnClickListener {
            // Firebase / Auth logout
        }
    }
}