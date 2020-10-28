package com.example.cleanarchdemo.domain.usecase.impl

import com.example.cleanarchdemo.data.local.db.CustomerEntity
import com.example.cleanarchdemo.data.state.DataState
import com.example.cleanarchdemo.di.registration.RegistrationScope
import com.example.cleanarchdemo.domain.repositories.CustomerRepository
import com.example.cleanarchdemo.domain.usecase.InsertCustomerUsecase
import javax.inject.Inject

@RegistrationScope
class InsertCustomerUsecaseImpl
@Inject constructor(
    private val repository: CustomerRepository
) : InsertCustomerUsecase {
    override suspend fun insertCustomer(customerEntity: CustomerEntity): DataState<Long> {
        return repository.insertCustomer(customerEntity)
    }
}