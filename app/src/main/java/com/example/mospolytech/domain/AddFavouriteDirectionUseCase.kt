package com.example.mospolytech.domain

import javax.inject.Inject

class AddFavouriteDirectionUseCase @Inject constructor(
    private val directionRepository: DirectionRepository
) {
    fun addFavouriteDirection(direction: Direction) {
        directionRepository.addFavouriteDirection(direction)
    }
}