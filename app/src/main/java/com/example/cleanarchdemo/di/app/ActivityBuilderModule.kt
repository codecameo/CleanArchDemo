package com.example.cleanarchdemo.di.app

import com.example.cleanarchdemo.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    internal abstract fun bindMainActivity(): MainActivity
}