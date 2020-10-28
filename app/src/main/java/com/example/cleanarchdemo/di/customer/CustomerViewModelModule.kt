package com.example.cleanarchdemo.di.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchdemo.di.ViewModelKey
import com.example.cleanarchdemo.viewmodel.CustomerViewModel
import com.example.cleanarchdemo.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CustomerViewModelModule {

    @CustomerScope
    @Binds
    abstract fun bindFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @CustomerScope
    @Binds
    @IntoMap
    @ViewModelKey(CustomerViewModel::class)
    abstract fun bindHomeViewModel(customerViewModel: CustomerViewModel): ViewModel
}