package com.example.cleanarchdemo.domain.repositories

import com.example.cleanarchdemo.data.local.db.CustomerEntity
import com.example.cleanarchdemo.data.state.DataState
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity

interface CustomerRepository {
    suspend fun insertCustomer(customerEntity: CustomerEntity) : DataState<Long>
    suspend fun getLatestConsumers() : DataState<List<CustomerInfoEntity>>
}