package com.example.mospolytech.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mospolytech.R

class DirectionViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val textViewName = view.findViewById<TextView>(R.id.textViewNameDirection)
    val textViewCount = view.findViewById<TextView>(R.id.textViewScoreDirection)
}