package com.example.shift_application.di

import android.content.Context
import com.example.shift_application.data.repostitory.RegistrationRepositoryImpl
import com.example.shift_application.data.shared.CredentialsStorage
import com.example.shift_application.domain.repository.RegistrationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideRegistrationRepository(credentialsStorage: CredentialsStorage): RegistrationRepository {
        return RegistrationRepositoryImpl(credentialsStorage = credentialsStorage)
    }


    @Provides
    fun provideCredentialsStorage(@ApplicationContext context: Context): CredentialsStorage {
        return CredentialsStorage(context = context)
    }


}