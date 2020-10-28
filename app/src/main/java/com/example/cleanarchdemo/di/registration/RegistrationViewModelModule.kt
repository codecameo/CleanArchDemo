package com.example.cleanarchdemo.di.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchdemo.di.ViewModelKey
import com.example.cleanarchdemo.viewmodel.RegistrationViewModel
import com.example.cleanarchdemo.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RegistrationViewModelModule {

    @RegistrationScope
    @Binds
    abstract fun bindFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @RegistrationScope
    @Binds
    @IntoMap
    @ViewModelKey(RegistrationViewModel::class)
    abstract fun bindHomeViewModel(registrationViewModel: RegistrationViewModel): ViewModel
}