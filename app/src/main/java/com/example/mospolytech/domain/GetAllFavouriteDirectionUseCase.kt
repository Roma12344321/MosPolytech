package com.example.mospolytech.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetAllFavouriteDirectionUseCase @Inject constructor(
    private val repository: DirectionRepository
) {
    fun getAllFavouriteDirection(): LiveData<List<Direction>> {
        return repository.getAllFavouriteDirection()
    }
}