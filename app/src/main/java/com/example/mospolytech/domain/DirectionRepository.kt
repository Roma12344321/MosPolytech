package com.example.mospolytech.domain

import androidx.lifecycle.LiveData

interface DirectionRepository {
    suspend fun addFavouriteDirection(direction: Direction)
    suspend fun deleteFavouriteDirection(id: Int)
    fun getFavouriteDirection(id: Int) : LiveData<Direction>
    fun getAllFavouriteDirection() : LiveData<List<Direction>>
}