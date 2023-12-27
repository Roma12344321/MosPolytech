package com.example.mospolytech.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetFavouriteDirectionUseCase @Inject constructor(
    private val repository: DirectionRepository
) {
    fun getFavouriteDirection(id: Int) : LiveData<Direction> {
        return repository.getFavouriteDirection(id)
    }
}