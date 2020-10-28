package com.example.cleanarchdemo.data.manager

import com.example.cleanarchdemo.data.local.db.AppDatabase
import com.example.cleanarchdemo.data.local.db.CustomerEntity
import com.example.cleanarchdemo.data.state.DataErrorResponse
import com.example.cleanarchdemo.data.state.DataState
import com.example.cleanarchdemo.data.state.DataState.Error
import com.example.cleanarchdemo.data.state.DataState.Success
import com.example.cleanarchdemo.data.state.DataSuccessResponse
import com.example.cleanarchdemo.di.app.AppScope
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity
import kotlinx.coroutines.delay
import javax.inject.Inject

@AppScope
class DataManagerImpl
@Inject constructor(
    private val appDatabase: AppDatabase
) : DataManager {

    override suspend fun insertConsumer(customerEntity: CustomerEntity): DataState<Long> {
        delay(1000)
        val rowId = appDatabase.getConsumerDao().insert(customerEntity)
        return if (rowId > 0) {
            Success(dataResponse = DataSuccessResponse(data = rowId))
        } else {
            Error(dataResponse = DataErrorResponse())
        }
    }

    override suspend fun getLatestConsumers(): DataState<List<CustomerInfoEntity>> {
        return try {
            Success(DataSuccessResponse(appDatabase.getConsumerDao().selectLastConsumers()))
        } catch (ex: Exception) {
            Error(DataErrorResponse())
        }
    }
}