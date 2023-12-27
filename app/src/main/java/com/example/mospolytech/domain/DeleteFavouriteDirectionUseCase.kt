package com.example.mospolytech.domain

import javax.inject.Inject

class DeleteFavouriteDirectionUseCase @Inject constructor(
    private val repository: DirectionRepository
) {
    suspend fun deleteFavouriteDirection(id: Int) {
        repository.deleteFavouriteDirection(id)
    }
}