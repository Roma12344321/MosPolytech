package com.example.mospolytech.domain

import androidx.lifecycle.LiveData

class GetAllDirectionUseCase(private val directionRepository: DirectionRepository) {
    fun getAllDirection() : LiveData<List<Direction>>{
        return directionRepository.getAllDirection()
    }
}