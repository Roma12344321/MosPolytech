package com.example.mospolytech.domain

import androidx.lifecycle.LiveData

interface DirectionRepository {
    fun addDirection(direction: Direction)
    fun getAllDirection() : LiveData<List<Direction>>
    suspend fun addFavouriteDirection(direction: Direction)
    suspend fun deleteFavouriteDirection(id: Int)
    fun getFavouriteDirection(id: Int) : LiveData<Direction>
    fun getAllFavouriteDirection() : LiveData<List<Direction>>
}