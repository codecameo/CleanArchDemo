package com.example.cleanarchdemo.data.manager

import com.example.cleanarchdemo.data.local.db.CustomerEntity
import com.example.cleanarchdemo.data.state.DataState
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity

interface DataManager {
    suspend fun insertConsumer(customerEntity: CustomerEntity): DataState<Long>

    suspend fun getLatestConsumers(): DataState<List<CustomerInfoEntity>>
}