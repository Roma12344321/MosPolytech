package com.example.mospolytech.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mospolytech.R
import com.example.mospolytech.domain.Direction
import com.example.mospolytech.domain.DirectionRepository
import javax.inject.Inject

class DirectionRepositoryImpl @Inject constructor(
    private val directionsDao: DirectionsDao,
) : DirectionRepository {

    override suspend fun addFavouriteDirection(direction: Direction) {
        directionsDao.addFavouriteDirection(direction)
    }

    override suspend fun deleteFavouriteDirection(id: Int) {
        directionsDao.deleteFavouriteDirection(id)
    }

    override fun getFavouriteDirection(id: Int): LiveData<Direction> {
        return directionsDao.getFavouriteDirection(id)
    }

    override fun getAllFavouriteDirection(): LiveData<List<Direction>> {
        return directionsDao.getAllFavouriteDirections()
    }
}