package com.example.shift_application.di

import com.example.shift_application.domain.repository.RegistrationRepository
import com.example.shift_application.domain.usecase.RegisterUserUseCase
import com.example.shift_application.domain.usecase.ValidateNameUseCase
import com.example.shift_application.domain.usecase.ValidatePasswordUseCase
import com.example.shift_application.domain.usecase.ValidateSurnameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object PresentationModule {

    @Provides
    fun provideValidatePasswordUseCase(): ValidatePasswordUseCase {
        return ValidatePasswordUseCase()
    }

    @Provides
    fun provideRegisterUserUseCase(registrationRepository: RegistrationRepository): RegisterUserUseCase {
        return RegisterUserUseCase(registrationRepository = registrationRepository)
    }

    @Provides
    fun provideValidateSurnameUseCase(): ValidateSurnameUseCase {
        return ValidateSurnameUseCase()
    }

    @Provides
    fun provideValidateNameUseCase(): ValidateNameUseCase {
        return ValidateNameUseCase()
    }

}