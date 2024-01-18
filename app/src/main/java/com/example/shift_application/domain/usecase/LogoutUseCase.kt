package com.example.shift_application.domain.usecase

import com.example.shift_application.domain.repository.RegistrationRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(private val repository: RegistrationRepository) {
    suspend fun execute() {
        repository.logout()
    }

}