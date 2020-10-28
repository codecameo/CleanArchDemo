package com.example.cleanarchdemo.domain.repositories

import com.example.cleanarchdemo.data.local.db.CustomerEntity
import com.example.cleanarchdemo.data.manager.DataManager
import com.example.cleanarchdemo.data.state.DataState
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val dataManager: DataManager
) : CustomerRepository {
    override suspend fun insertCustomer(customerEntity: CustomerEntity): DataState<Long> {
        return dataManager.insertConsumer(customerEntity)
    }

    override suspend fun getLatestConsumers(): DataState<List<CustomerInfoEntity>> {
        return dataManager.getLatestConsumers()
    }
}