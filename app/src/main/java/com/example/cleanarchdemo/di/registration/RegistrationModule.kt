package com.example.cleanarchdemo.di.registration

import com.example.cleanarchdemo.ui.registration.model.RegistrationModel
import com.example.cleanarchdemo.utils.FormDataValidator
import dagger.Module
import dagger.Provides

@Module
object RegistrationModule {

    @RegistrationScope
    @Provides
    fun provideFormDataValidator() = FormDataValidator()

    @RegistrationScope
    @Provides
    fun provideRegistrationModel(formDataValidator: FormDataValidator) = RegistrationModel(formDataValidator)
}