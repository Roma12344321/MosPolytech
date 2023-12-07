package com.example.mospolytech.presentation.viewmodel

import android.app.Application
import com.example.mospolytech.di.DaggerApplicationComponent

class DirectionApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.create()
    }

}