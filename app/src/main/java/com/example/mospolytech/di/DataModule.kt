package com.example.mospolytech.di

import android.app.Application
import com.example.mospolytech.data.AppDataBase
import com.example.mospolytech.data.DirectionRepositoryImpl
import com.example.mospolytech.data.DirectionsDao
import com.example.mospolytech.domain.DirectionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DataModule {
    @Singleton
    @Binds
    fun bindDirectionRepository(impl : DirectionRepositoryImpl) : DirectionRepository

    companion object {
        @Provides
        fun provideDirectionsDao(application: Application) : DirectionsDao {
            return AppDataBase.getInstance(application).directionsDao()
        }
    }
}