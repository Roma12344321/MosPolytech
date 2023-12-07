package com.example.mospolytech.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetAllDirectionUseCase @Inject constructor(private val directionRepository: DirectionRepository) {
    fun getAllDirection() : LiveData<List<Direction>>{
        return directionRepository.getAllDirection()
    }
}