package com.example.cleanarchdemo.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CustomerEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getConsumerDao(): ConsumerDao
}