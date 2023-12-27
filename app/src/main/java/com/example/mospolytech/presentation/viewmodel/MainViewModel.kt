package com.example.mospolytech.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mospolytech.data.DirectionRepositoryImpl
import com.example.mospolytech.domain.AddDirectionUseCase
import com.example.mospolytech.domain.AddFavouriteDirectionUseCase
import com.example.mospolytech.domain.DeleteFavouriteDirectionUseCase
import com.example.mospolytech.domain.Direction
import com.example.mospolytech.domain.GetAllDirectionUseCase
import com.example.mospolytech.domain.GetAllFavouriteDirectionUseCase
import com.example.mospolytech.domain.GetFavouriteDirectionUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val addDirectionUseCase: AddDirectionUseCase,
    private val getAllDirectionUseCase: GetAllDirectionUseCase,
    private val addFavouriteDirectionUseCase: AddFavouriteDirectionUseCase,
    private val deleteFavouriteDirectionUseCase: DeleteFavouriteDirectionUseCase,
    private val getAllFavouriteDirectionUseCase: GetAllFavouriteDirectionUseCase,
    private val getFavouriteDirectionUseCase: GetFavouriteDirectionUseCase
) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.Main)
    fun getAllDirection(): LiveData<List<Direction>> {
        return getAllDirectionUseCase.getAllDirection()
    }

    fun addDirection(direction: Direction) {
        addDirectionUseCase.addDirection(direction)
    }

    fun addFavouriteDirection(direction: Direction) {
        scope.launch {
            addFavouriteDirectionUseCase.addFavouriteDirection(direction)
        }
    }

    fun deleteFavouriteDirection(id: Int) {
        scope.launch {
            deleteFavouriteDirectionUseCase.deleteFavouriteDirection(id)
        }
    }

    val allFavouriteDirection = getAllFavouriteDirectionUseCase.getAllFavouriteDirection()

    fun getFavouriteDirection(id: Int) : LiveData<Direction> {
        return getFavouriteDirectionUseCase.getFavouriteDirection(id)
    }
}