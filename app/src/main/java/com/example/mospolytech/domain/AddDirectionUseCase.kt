package com.example.mospolytech.domain

import javax.inject.Inject

class AddDirectionUseCase @Inject constructor(private val directionRepository: DirectionRepository) {
    fun addDirection(direction: Direction){
        directionRepository.addDirection(direction)
    }
}