package com.example.cleanarchdemo.di.app

import com.example.cleanarchdemo.data.manager.DataManager
import com.example.cleanarchdemo.data.manager.DataManagerImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AppBindModule {

    @Binds
    abstract fun bindDataManager(dataManagerImpl: DataManagerImpl) : DataManager
}