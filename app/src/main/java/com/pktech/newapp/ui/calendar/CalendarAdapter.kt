package com.pktech.myapp.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pktech.myapp.data.model.CalendarDayModel
import com.pktech.myapp.databinding.ItemCalendarDayBinding

class CalendarAdapter : RecyclerView.Adapter<CalendarAdapter.DayViewHolder>() {

    private val list = mutableListOf<CalendarDayModel>()

    inner class DayViewHolder(val binding: ItemCalendarDayBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val binding = ItemCalendarDayBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return DayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        val item = list[position]

        holder.binding.tvDate.text = item.date.dayOfMonth.toString()
        holder.binding.tvShift.text = item.shift

        val color = when {
            item.isHoliday -> 0xFFFFCDD2.toInt()   // Red
            item.shift.contains("NIGHT") -> 0xFFD1C4E9.toInt() // Purple
            item.shift.contains("MORNING") -> 0xFFFFF9C4.toInt() // Yellow
            item.shift.contains("FULL") -> 0xFFC8E6C9.toInt() // Green
            else -> 0xFFE3F2FD.toInt()
        }

        holder.binding.root.setBackgroundColor(color)
    }

    override fun getItemCount() = list.size

    fun submitList(newList: List<CalendarDayModel>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}