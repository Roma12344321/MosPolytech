package com.example.mospolytech.di

import androidx.lifecycle.ViewModel
import com.example.mospolytech.presentation.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel : MainViewModel) : ViewModel
}