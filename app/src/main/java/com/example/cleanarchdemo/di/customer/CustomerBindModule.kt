package com.example.cleanarchdemo.di.customer

import com.example.cleanarchdemo.domain.repositories.CustomerRepository
import com.example.cleanarchdemo.domain.repositories.CustomerRepositoryImpl
import com.example.cleanarchdemo.domain.usecase.LatestCustomerUsecase
import com.example.cleanarchdemo.domain.usecase.impl.LatestCustomerUsecaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CustomerBindModule {

    @Binds
    abstract fun bindCustomerUsecase(latestCustomerUsecaseImpl: LatestCustomerUsecaseImpl): LatestCustomerUsecase

    @Binds
    abstract fun bindCustomerRepository(customerRepositoryImpl: CustomerRepositoryImpl): CustomerRepository
}