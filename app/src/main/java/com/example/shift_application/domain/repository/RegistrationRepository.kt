package com.example.shift_application.domain.repository

import com.example.shift_application.data.entity.CredentialsBody
import com.example.shift_application.data.entity.RegistrationBody

interface RegistrationRepository  {

    suspend fun registerUser(registrationBody: RegistrationBody)

    suspend fun getUserInformation() : CredentialsBody

    suspend fun checkIfLoggedIn() : Boolean

    suspend fun logout()

}