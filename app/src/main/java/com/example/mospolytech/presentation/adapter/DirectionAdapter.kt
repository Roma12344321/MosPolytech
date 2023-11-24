package com.example.mospolytech.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mospolytech.R
import com.example.mospolytech.domain.Direction

class DirectionAdapter : ListAdapter<Direction, DirectionViewHolder>(DirectionItemDiffCallBack()) {

    var onItemClickListener : OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.direction_item,parent,false)
        return DirectionViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: DirectionViewHolder, position: Int) {
        val direction = getItem(position)
        viewHolder.view.setOnClickListener {
            onItemClickListener?.onItemClick(direction)
        }
        viewHolder.textViewName.text = direction.name
        viewHolder.textViewCount.text = direction.passScore
    }

    interface OnItemClickListener{
        fun onItemClick(direction: Direction)
    }
}