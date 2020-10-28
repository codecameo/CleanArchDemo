package com.example.cleanarchdemo

import com.example.cleanarchdemo.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ProjectApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}