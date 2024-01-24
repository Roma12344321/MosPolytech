package com.example.mospolytech.di

import android.app.Application
import android.content.Context
import com.example.mospolytech.presentation.fragments.DetailActivityFragment
import com.example.mospolytech.presentation.fragments.FavouriteFragment
import com.example.mospolytech.presentation.fragments.DirectionListFragment
import com.example.mospolytech.presentation.fragments.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class,ViewModelModule::class])
interface ApplicationComponent {
    fun inject(fragment: DirectionListFragment)
    fun inject(fragment: DetailActivityFragment)
    fun inject(fragment: FavouriteFragment)
    fun inject(fragment: MainFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
            @BindsInstance context: Context
        ) : ApplicationComponent
    }
}