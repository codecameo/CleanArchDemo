package com.example.cleanarchdemo.domain.usecase

import com.example.cleanarchdemo.data.state.DataState
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity

interface LatestCustomerUsecase {
    suspend fun getLatestConsumers(): DataState<List<CustomerInfoEntity>>
}