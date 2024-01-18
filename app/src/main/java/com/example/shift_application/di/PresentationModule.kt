package com.example.shift_application.di

import com.example.shift_application.domain.repository.RegistrationRepository
import com.example.shift_application.domain.usecase.GetUserInformationUseCase
import com.example.shift_application.domain.usecase.validate.ValidateNameUseCase
import com.example.shift_application.domain.usecase.validate.ValidatePasswordUseCase
import com.example.shift_application.domain.usecase.validate.ValidateSurnameUseCase
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
    fun provideGetUserInfoUseCase(registrationRepository: RegistrationRepository): GetUserInformationUseCase {
        return GetUserInformationUseCase(repository = registrationRepository)
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