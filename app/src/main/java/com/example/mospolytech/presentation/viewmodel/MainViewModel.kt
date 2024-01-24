package com.example.mospolytech.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mospolytech.domain.AddFavouriteDirectionUseCase
import com.example.mospolytech.domain.DeleteFavouriteDirectionUseCase
import com.example.mospolytech.domain.Direction
import com.example.mospolytech.domain.GetAllFavouriteDirectionUseCase
import com.example.mospolytech.domain.GetFavouriteDirectionUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val addFavouriteDirectionUseCase: AddFavouriteDirectionUseCase,
    private val deleteFavouriteDirectionUseCase: DeleteFavouriteDirectionUseCase,
    private val getAllFavouriteDirectionUseCase: GetAllFavouriteDirectionUseCase,
    private val getFavouriteDirectionUseCase: GetFavouriteDirectionUseCase
) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.Main)

    private val _direction = MutableLiveData<Direction>()
    val direction : LiveData<Direction>
        get() = _direction

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

    fun changeFavouriteState(direction: Direction){
        scope.launch {
            val newItem = direction.copy(favourite = !direction.favourite)
            addFavouriteDirectionUseCase.addFavouriteDirection(newItem)
        }
    }

    fun getDirection(direction: Direction) {
        _direction.value = direction
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}