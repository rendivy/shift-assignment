package com.example.shift_application.domain.usecase

import com.example.shift_application.data.entity.CredentialsBody
import com.example.shift_application.domain.repository.RegistrationRepository
import javax.inject.Inject

class GetUserInformationUseCase @Inject constructor(private val repository: RegistrationRepository) {
    suspend fun execute(): CredentialsBody {
        return repository.getUserInformation()
    }
}