package com.example.shift_application.domain.usecase

import com.example.shift_application.data.entity.RegistrationBody
import com.example.shift_application.domain.repository.RegistrationRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(private val registrationRepository: RegistrationRepository) {

    suspend fun execute(name: String, surname: String, birthDate: String) {
        var registrationBody = RegistrationBody(name, surname, birthDate)
        registrationRepository.registerUser(registrationBody)
    }
}