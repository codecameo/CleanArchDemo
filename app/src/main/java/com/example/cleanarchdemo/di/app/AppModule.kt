package com.example.cleanarchdemo.di.app

import android.content.Context
import androidx.room.Room
import com.example.cleanarchdemo.ProjectApplication
import com.example.cleanarchdemo.data.local.db.AppDatabase
import com.example.cleanarchdemo.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

@Module
object AppModule {

    @AppScope
    @Provides
    fun provideDatabaseName(): String {
        return DATABASE_NAME
    }

    @AppScope
    @Provides
    fun provideContext(projectApplication: ProjectApplication): Context {
        return projectApplication
    }

    @AppScope
    @Provides
    fun provideAppDb(context: Context, name : String): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, name)
            .build()
    }

    @AppScope
    @Provides
    fun backgroundDispatcher() = Dispatchers.IO
}