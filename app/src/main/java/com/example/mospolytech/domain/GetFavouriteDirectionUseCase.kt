package com.example.mospolytech.domain

import javax.inject.Inject

class GetFavouriteDirectionUseCase @Inject constructor(
    private val repository: DirectionRepository
) {
    fun getFavouriteDirection(id: Int) : Direction {
        return repository.getFavouriteDirection(id)
    }
}