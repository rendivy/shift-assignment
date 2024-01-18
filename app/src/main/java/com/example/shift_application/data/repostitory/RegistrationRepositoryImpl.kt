package com.example.shift_application.data.repostitory

import com.example.shift_application.data.entity.CredentialsBody
import com.example.shift_application.data.entity.RegistrationBody
import com.example.shift_application.data.shared.CredentialsStorage
import com.example.shift_application.domain.repository.RegistrationRepository
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(private val credentialsStorage: CredentialsStorage) :
    RegistrationRepository {

    override suspend fun registerUser(registrationBody: RegistrationBody) {
        credentialsStorage.saveCredentials(
            registrationBody.name,
            registrationBody.surname,
            registrationBody.birthDate
        )
    }

    override suspend fun getUserInformation(): CredentialsBody {
        return credentialsStorage.getCredentials()
    }

    override suspend fun checkIfLoggedIn(): Boolean {
        return credentialsStorage.isUserLoggedIn()
    }

    override suspend fun logout() {
        credentialsStorage.logout()
    }

}