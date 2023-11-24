package com.example.mospolytech.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.mospolytech.domain.Direction

class DirectionItemDiffCallBack : DiffUtil.ItemCallback<Direction>() {
    override fun areItemsTheSame(oldItem: Direction, newItem: Direction): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Direction, newItem: Direction): Boolean {
        return oldItem == newItem
    }
}