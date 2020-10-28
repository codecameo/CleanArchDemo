package com.example.cleanarchdemo.di.app

import com.example.cleanarchdemo.ProjectApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScope
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilderModule::class, AppBindModule::class])
interface AppComponent : AndroidInjector<ProjectApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(projectApplication: ProjectApplication): Builder

        fun build(): AppComponent
    }
}