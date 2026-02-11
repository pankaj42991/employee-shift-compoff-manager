package com.pktech.myapp.shifts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pktech.myapp.data.local.entities.ShiftEntity
import com.pktech.myapp.databinding.ItemShiftBinding

class ShiftAdapter(private val isAdmin: Boolean) :
    RecyclerView.Adapter<ShiftAdapter.ShiftViewHolder>() {

    private val shifts = mutableListOf<ShiftEntity>()

    inner class ShiftViewHolder(val binding: ItemShiftBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShiftViewHolder {
        val binding = ItemShiftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShiftViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShiftViewHolder, position: Int) {
        val shift = shifts[position]
        holder.binding.tvEmployee.text = shift.employeeName
        holder.binding.tvShift.text = shift.shiftType
        holder.binding.tvDate.text = shift.date

        // Color-code shift type
        holder.binding.root.setBackgroundColor(
            when (shift.shiftType) {
                "Morning" -> 0xFFFFFF99.toInt()
                "General" -> 0xFF99CCFF.toInt()
                "Second" -> 0xFFFFCC99.toInt()
                "Night" -> 0xFFCC99FF.toInt()
                else -> 0xFFFFFFFF.toInt()
            }
        )

        // Admin can click to edit
        if (isAdmin) {
            holder.binding.root.setOnClickListener {
                // TODO: Open dialog to change employee or shift manually
            }
        }
    }

    override fun getItemCount(): Int = shifts.size

    fun submitList(list: List<ShiftEntity>) {
        shifts.clear()
        shifts.addAll(list)
        notifyDataSetChanged()
    }
}