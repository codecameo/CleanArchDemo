package com.example.cleanarchdemo.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity

@Dao
interface ConsumerDao {

    @Insert
    suspend fun insert(customerEntity: CustomerEntity): Long

    @Query("SELECT username,phone FROM CustomerEntity ORDER BY created_at DESC LIMIT 10")
    suspend fun selectLastConsumers() : List<CustomerInfoEntity>
}