package com.example.shift_application.domain.usecase

import com.example.shift_application.domain.repository.RegistrationRepository
import javax.inject.Inject

class IsUserLoginUseCase @Inject constructor(private val repository: RegistrationRepository) {

    suspend fun execute(): Boolean {
        return repository.checkIfLoggedIn()
    }
}