package com.example.mospolytech.domain

import androidx.lifecycle.LiveData

interface DirectionRepository {
    fun addDirection(direction: Direction)
    fun getAllDirection() : LiveData<List<Direction>>
}