package com.example.mospolytech.domain

import androidx.lifecycle.LiveData

interface DirectionRepository {
    fun addDirection(direction: Direction)
    fun getAllDirection() : LiveData<List<Direction>>
    fun addFavouriteDirection(direction: Direction)
    fun deleteFavouriteDirection(id: Int)
    fun getFavouriteDirection(id: Int) : Direction
    fun getAllFavouriteDirection() : LiveData<List<Direction>>
}