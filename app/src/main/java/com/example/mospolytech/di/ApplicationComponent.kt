package com.example.mospolytech.di

import androidx.fragment.app.Fragment
import com.example.mospolytech.presentation.fragments.InfMathRusFragment
import dagger.Component

@Component(modules = [DataModule::class,ViewModelModule::class])
interface ApplicationComponent {
    fun inject(fragment: InfMathRusFragment)
}