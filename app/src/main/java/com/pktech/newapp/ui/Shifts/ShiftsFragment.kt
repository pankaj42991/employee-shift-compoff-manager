package com.pktech.myapp.shifts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pktech.myapp.databinding.FragmentShiftsBinding

class ShiftsFragment : Fragment() {

    private var _binding: FragmentShiftsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShiftsViewModel by viewModels()

    private var isAdmin = false
    private lateinit var adapter: ShiftAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShiftsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isAdmin = viewModel.isAdminUser()

        setupRecyclerView()
        loadShifts()

        if (isAdmin) {
            binding.btnAutoRotate.setOnClickListener {
                viewModel.autoRotateNightShift()
                loadShifts()
                Toast.makeText(requireContext(), "Night shift rotated!", Toast.LENGTH_SHORT).show()
            }
        } else {
            binding.btnAutoRotate.visibility = View.GONE
        }
    }

    private fun setupRecyclerView() {
        adapter = ShiftAdapter(isAdmin)
        binding.recyclerShifts.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerShifts.adapter = adapter
    }

    private fun loadShifts() {
        val shifts = viewModel.getShiftsForWeek()
        adapter.submitList(shifts)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}