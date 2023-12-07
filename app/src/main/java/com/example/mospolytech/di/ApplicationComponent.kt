package com.example.mospolytech.di

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.mospolytech.presentation.fragments.InfMathRusFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class,ViewModelModule::class])
interface ApplicationComponent {
    fun inject(fragment: InfMathRusFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ) : ApplicationComponent
    }
}