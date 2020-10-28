package com.example.cleanarchdemo.domain.usecase

import com.example.cleanarchdemo.data.local.db.CustomerEntity
import com.example.cleanarchdemo.data.state.DataState

interface InsertCustomerUsecase {
    suspend fun insertCustomer(customerEntity: CustomerEntity) : DataState<Long>
}