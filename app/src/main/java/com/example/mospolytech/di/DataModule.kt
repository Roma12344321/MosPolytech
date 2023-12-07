package com.example.mospolytech.di

import com.example.mospolytech.data.DirectionRepositoryImpl
import com.example.mospolytech.domain.DirectionRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {
    @Binds
    fun bindDirectionRepository(impl : DirectionRepositoryImpl) : DirectionRepository
}