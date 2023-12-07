package com.example.mospolytech.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mospolytech.data.DirectionRepositoryImpl
import com.example.mospolytech.domain.AddDirectionUseCase
import com.example.mospolytech.domain.Direction
import com.example.mospolytech.domain.GetAllDirectionUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val addDirectionUseCase: AddDirectionUseCase,
    private val getAllDirectionUseCase: GetAllDirectionUseCase
) : ViewModel() {


    fun getAllDirection(): LiveData<List<Direction>> {
        return getAllDirectionUseCase.getAllDirection()
    }

    fun addDirection(direction: Direction) {
        addDirectionUseCase.addDirection(direction)
    }
}