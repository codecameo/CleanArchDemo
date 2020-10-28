package com.example.cleanarchdemo.domain.usecase.impl

import com.example.cleanarchdemo.data.state.DataState
import com.example.cleanarchdemo.di.customer.CustomerScope
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity
import com.example.cleanarchdemo.domain.repositories.CustomerRepository
import com.example.cleanarchdemo.domain.usecase.LatestCustomerUsecase
import javax.inject.Inject

@CustomerScope
class LatestCustomerUsecaseImpl
@Inject constructor(
    private val repository: CustomerRepository
) : LatestCustomerUsecase {
    override suspend fun getLatestConsumers(): DataState<List<CustomerInfoEntity>> {
        return repository.getLatestConsumers()
    }
}