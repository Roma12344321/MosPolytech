package com.example.mospolytech.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mospolytech.R
import com.example.mospolytech.domain.Direction
import java.lang.RuntimeException

class DirectionAdapter : ListAdapter<Direction, DirectionViewHolder>(DirectionItemDiffCallBack()) {

    var onItemClickListener : OnItemClickListener? = null
    var onStarClickListener : OnStarClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirectionViewHolder {
        val layout = when (viewType){
            VIEW_TYPE_FAVOURITE -> R.layout.direction_item_favourite
            VIEW_TYPE_NOT_FAVOURITE -> R.layout.direction_item
            else -> throw RuntimeException("Layout does not exist")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return DirectionViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: DirectionViewHolder, position: Int) {
        val direction = getItem(position)
        viewHolder.view.setOnClickListener {
            onItemClickListener?.onItemClick(direction)
        }
        viewHolder.imageViewStar.setOnClickListener {
            onStarClickListener?.onStarClick(direction)
        }
        viewHolder.textViewName.text = direction.name
        viewHolder.textViewCount.text = direction.passScore
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.favourite){
            VIEW_TYPE_FAVOURITE
        }
        else {
            VIEW_TYPE_NOT_FAVOURITE
        }
    }

    interface OnItemClickListener{
        fun onItemClick(direction: Direction)
    }
    interface OnStarClickListener{
        fun onStarClick(direction: Direction)
    }

    companion object {
        private const val VIEW_TYPE_FAVOURITE = 1
        private const val VIEW_TYPE_NOT_FAVOURITE = 2
    }
}