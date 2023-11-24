package com.example.mospolytech.domain

class AddDirectionUseCase(private val directionRepository: DirectionRepository) {
    fun addDirection(direction: Direction){
        directionRepository.addDirection(direction)
    }
}