package com.pktech.myapp.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.pktech.myapp.databinding.FragmentCalendarBinding
import java.time.LocalDate
import java.time.YearMonth

class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CalendarViewModel by viewModels()
    private lateinit var adapter: CalendarAdapter

    private var currentMonth = YearMonth.now()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CalendarAdapter()
        binding.recyclerCalendar.layoutManager = GridLayoutManager(requireContext(), 7)
        binding.recyclerCalendar.adapter = adapter

        binding.tvMonth.text = currentMonth.month.name + " " + currentMonth.year

        loadCalendar()

        binding.btnPrev.setOnClickListener {
            currentMonth = currentMonth.minusMonths(1)
            loadCalendar()
        }

        binding.btnNext.setOnClickListener {
            currentMonth = currentMonth.plusMonths(1)
            loadCalendar()
        }
    }

    private fun loadCalendar() {
        binding.tvMonth.text = currentMonth.month.name + " " + currentMonth.year
        val days = viewModel.getMonthCalendar(currentMonth)
        adapter.submitList(days)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}