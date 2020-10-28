package com.example.cleanarchdemo.di.registration

import com.example.cleanarchdemo.domain.repositories.CustomerRepository
import com.example.cleanarchdemo.domain.repositories.CustomerRepositoryImpl
import com.example.cleanarchdemo.domain.usecase.InsertCustomerUsecase
import com.example.cleanarchdemo.domain.usecase.impl.InsertCustomerUsecaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RegistrationBindModule {

    @Binds
    abstract fun bindCustomerUsecase(insertCustomerUsecase: InsertCustomerUsecaseImpl): InsertCustomerUsecase

    @Binds
    abstract fun bindCustomerRepository(customerRepositoryImpl: CustomerRepositoryImpl): CustomerRepository
}