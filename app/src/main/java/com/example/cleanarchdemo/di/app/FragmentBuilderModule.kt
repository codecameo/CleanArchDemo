package com.example.cleanarchdemo.di.app

import com.example.cleanarchdemo.di.customer.CustomerBindModule
import com.example.cleanarchdemo.di.customer.CustomerScope
import com.example.cleanarchdemo.di.customer.CustomerViewModelModule
import com.example.cleanarchdemo.di.registration.RegistrationBindModule
import com.example.cleanarchdemo.di.registration.RegistrationModule
import com.example.cleanarchdemo.di.registration.RegistrationScope
import com.example.cleanarchdemo.di.registration.RegistrationViewModelModule
import com.example.cleanarchdemo.ui.customer.CustomerFragment
import com.example.cleanarchdemo.ui.home.HomeFragment
import com.example.cleanarchdemo.ui.registration.RegistrationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @CustomerScope
    @ContributesAndroidInjector(modules = [CustomerViewModelModule::class, CustomerBindModule::class])
    internal abstract fun bindCustomerFragment(): CustomerFragment

    @RegistrationScope
    @ContributesAndroidInjector(modules = [RegistrationViewModelModule::class, RegistrationBindModule::class, RegistrationModule::class])
    internal abstract fun bindRegistrationFragment(): RegistrationFragment

    @ContributesAndroidInjector
    internal abstract fun bindHomeFragment(): HomeFragment
}