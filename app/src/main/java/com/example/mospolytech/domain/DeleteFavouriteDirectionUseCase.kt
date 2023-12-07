package com.example.mospolytech.domain

import javax.inject.Inject

class DeleteFavouriteDirectionUseCase @Inject constructor(
    private val repository: DirectionRepository
) {
    fun deleteFavouriteDirection(id: Int) {
        repository.deleteFavouriteDirection(id)
    }
}